package com.university.dao.impl;

import com.university.dao.RoleDao;
import com.university.dao.UserDao;
import com.university.model.Role;
import com.university.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired private SessionFactory sessionFactory;
    @Autowired private RoleDao roleDao;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public User findByLogin(String login) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login))
                .add(Restrictions.eq("active", true))
                .uniqueResult();
    }

    @Override
    public User findById(int id) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

    @Override
    public void saveOrUpdate(User user) {
        getSession().saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int userId) {
        User user = findById(userId);
        if (!Objects.isNull(user)){
            user.setActive(false);
            saveOrUpdate(user);
        }
    }

    @Override
    public void setRole(int userId, Role.Name roleName) {
        Role role = roleDao.getRoleByName(roleName);
        User user = findById(userId);
        if (!Objects.isNull(role) && !Objects.isNull(user)){
            user.setRole(role);
            saveOrUpdate(user);
        }
    }
}

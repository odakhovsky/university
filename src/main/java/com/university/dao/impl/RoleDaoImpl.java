package com.university.dao.impl;

import com.university.dao.RoleDao;
import com.university.model.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Role getRoleById(int id) {
        return (Role) getSession().get(Role.class, id);
    }

    @Override
    public Role getRoleByName(Role.Name nameEntity) {
        String hql = "FROM Role WHERE name = :name";
        Query query = getSession().createQuery(hql);
        query.setParameter("name", nameEntity);

        return (Role) query.uniqueResult();
    }

    @Override
    public List<Role> getRolesByIds(Set<Integer> roleIds) {
        String hql = "FROM Role where id IN (:ids)";
        Query query = getSession().createQuery(hql);
        query.setParameterList("ids", roleIds);

        return query.list();
    }

    @Override
    public int saveRole(Role Role) {
        return (int) getSession().save(Role);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getAllRoles() {
        return getSession().createCriteria(Role.class).list();
    }

    @Override
    public void updateRole(Role Role) {
        getSession().update(Role);
    }

    @Override
    public void deleteRole(Role Role) {
        getSession().delete(Role);
    }
}

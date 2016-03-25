package com.university.service.impl;

import com.university.bean.UserBean;
import com.university.dao.RoleDao;
import com.university.dao.UserDao;
import com.university.model.Role;
import com.university.model.User;
import com.university.service.UserService;
import com.university.util.Cipher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Service("UserDetails")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public UserBean getUserByLogin(String login) {
        return new UserBean(userDao.findByLogin(login));
    }

    @Override
    public UserBean getUserById(int id) {
        return new UserBean(userDao.findById(id));
    }

    @Override
    public void create(String name, String login, String password, Role.Name roleName) {
        User user = new User();

        user.setLogin(login);
        user.setName(name);
        user.setPassword(Cipher.encrypt(password));
        user.setRole(roleDao.getRoleByName(roleName));
        user.setActive(true);

        userDao.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void setRole(int userId, Role.Name roleName) {
        userDao.setRole(userId, roleName);
    }
}

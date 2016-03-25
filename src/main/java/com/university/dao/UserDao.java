package com.university.dao;

import com.university.model.Role;
import com.university.model.User;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface UserDao {

    User findByLogin(String login);

    User findById(int id);

    public void saveOrUpdate(User user);

    public void deleteUser(int userId);

    public void setRole(int userId, Role.Name roleName);

}

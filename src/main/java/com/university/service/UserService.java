package com.university.service;

import com.university.bean.UserBean;
import com.university.model.Role;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface UserService {

    UserBean getUserByLogin(String login);

    UserBean getUserById(int id);

    public void create(String name, String login, String password, Role.Name roleName);

    public void deleteUser(int userId);

    public void setRole(int userId, Role.Name roleName);

}

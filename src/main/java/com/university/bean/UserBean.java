package com.university.bean;

import com.university.model.Role;
import com.university.model.User;

import java.util.Objects;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class UserBean {

    private int id;
    private String name;
    private String login;
    private boolean active;
    private Role.Name role;

    public UserBean() {
    }

    public UserBean(User user){
        setId(user.getId());
        setName(user.getName());
        if (!Objects.isNull(user.getRole())){
            setRole(user.getRole().getName());
        }
        setActive(user.getActive());
        setLogin(user.getLogin());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role.Name getRole() {
        return role;
    }

    public void setRole(Role.Name role) {
        this.role = role;
    }

    public boolean isAdmin(){
        return Role.Name.ROLE_ADMIN.equals(role);
    }

    public boolean isTeacher(){
        return Role.Name.ROLE_TEACHER.equals(role);
    }
}

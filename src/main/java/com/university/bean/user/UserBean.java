package com.university.bean.user;

import com.university.model.Role;
import com.university.model.User;

import java.util.Objects;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class UserBean extends SimpleUserBean {

    private String login;
    private boolean active;
    private Role.Name role;

    public UserBean() {
        super();
    }

    public UserBean(User user){
        super(user.getId(), user.getName());
        if (!Objects.isNull(user.getRole())){
            setRole(user.getRole().getName());
        }
        setActive(user.getActive());
        setLogin(user.getLogin());
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

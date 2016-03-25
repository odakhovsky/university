package com.university.bean.user;

import com.university.model.User;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class SimpleUserBean {

    private int id;
    private String name;

    public SimpleUserBean(){}

    public SimpleUserBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleUserBean(User user) {
        setId(user.getId());
        setName(user.getName());
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
}

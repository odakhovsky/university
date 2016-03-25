package com.university.bean.subject;

import com.university.model.Subject;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class SubjectBean {
    private int id;
    private String name;

    public SubjectBean(Subject subject){
        setId(subject.getId());
        setName(subject.getName());
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

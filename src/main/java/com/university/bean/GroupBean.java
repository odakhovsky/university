package com.university.bean;

import com.university.bean.subject.SubjectBean;
import com.university.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class GroupBean {

    private int id;
    private String name;
    private List<SubjectBean> subjects = new ArrayList<>();

    public GroupBean(Group group){
        setId(group.getId());
        setName(group.getName());
        if (!Objects.isNull(group.getSubjects()) || !group.getSubjects().isEmpty()) {
            subjects.addAll(group.getSubjects().stream().map(SubjectBean::new).collect(Collectors.toList()));
        }
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

    public List<SubjectBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectBean> subjects) {
        this.subjects = subjects;
    }
}

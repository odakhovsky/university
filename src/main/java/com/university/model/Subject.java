package com.university.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVE")
    private Boolean active = true;

    @ManyToMany
    @JoinTable(
            name = "TEACHER_SUBJECT",
            joinColumns = {@JoinColumn(name = "SUBJECT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
    )
    private List<User> teaches = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "GROUP_SUBJECT",
            joinColumns = {@JoinColumn(name = "GROUP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")}
    )
    private List<Group> groups = new ArrayList<>();

    public Subject(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getTeaches() {
        return teaches;
    }

    public void setTeaches(List<User> teaches) {
        this.teaches = teaches;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void addTeacher(User teacher){
        if (!teaches.contains(teacher)){
            teaches.add(teacher);
        }
    }
}

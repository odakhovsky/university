package com.university.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Entity
@Table(name = "GROUPS")
public class Group {

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
            name = "GROUP_SUBJECT",
            joinColumns = {@JoinColumn(name = "GROUP_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SUBJECT_ID")}
    )
    private List<Subject> subjects = new ArrayList<>();

    public Group(){}

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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject subject){
        if (!subjects.contains(subject)){
            subjects.add(subject);
        }
    }
}

package com.university.model;

/**
 * Created by volodymyrO on 25.03.16.
 */

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;


    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;

    @Column(name = "PASSWORD", nullable = false)
    private String password;


    @Column(name = "ACTIVE")
    private Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "ROLE")
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "TEACHER_SUBJECT",
            joinColumns = {@JoinColumn(name = "SUBJECT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID")}
    )
    private List<Subject> subjects = new ArrayList<>();

    public User(){}

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
package com.university.model;

import javax.persistence.*;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Entity
@Table(name = "ROLE")
public class Role {

    public enum Name {ROLE_ADMIN, ROLE_TEACHER}

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    @Enumerated(EnumType.STRING)
    private Name name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}

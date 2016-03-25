package com.university.dao;

import com.university.model.Group;
import com.university.model.Subject;

import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface GroupDao {
    void saveOrUpdate(Group group);
    List<Group> findAllForTeacher(int teacherId);
    Group findByName(String name);//todo in future get with ignore case
    Group findById(int id);
}

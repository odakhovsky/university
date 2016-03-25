package com.university.dao;

import com.university.model.Subject;

import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface SubjectDao {
    void saveOrUpdate(Subject subject);
    List<Subject> findAllForTeacher(int teacherId);
    Subject findByName(String name);//todo in future get with ignore case
    Subject findById(int id);
}

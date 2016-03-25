package com.university.service;


import com.university.bean.subject.SubjectBean;

import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface SubjectService {
    void create(String name, int teacherId);
    void remove(int subjectId);
    List<SubjectBean> getAllForTeacher(int teacherId);
    SubjectBean getById(int id);
    SubjectBean getByName(String name);
    boolean isNameUnique(String name);
    void addTeacherToSubject(int subjectId, int teacherId);
}

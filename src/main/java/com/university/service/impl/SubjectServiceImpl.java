package com.university.service.impl;

import com.university.bean.subject.SubjectBean;
import com.university.bean.subject.TeachersSubjectBean;
import com.university.dao.SubjectDao;
import com.university.dao.UserDao;
import com.university.model.Role;
import com.university.model.Subject;
import com.university.model.User;
import com.university.service.SubjectService;
import com.university.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by volodymyrO on 25.03.16.
 */

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired private SubjectDao subjectDao;
    @Autowired private UserDao userDao;


    @Override
    public void create(String name, int teacherId) {
        User teacher = userDao.findById(teacherId);

        if (Objects.isNull(teacher) || AuthUtils.hasRole(teacher, Role.Name.ROLE_TEACHER)) {
            throw new IllegalArgumentException("This user should has a TEACHER role");
        }

        if (StringUtils.isEmpty(name)){
            throw new IllegalArgumentException("Subject name should be not empty!");
        }

        Subject subject = new Subject();
        subject.setName(name.trim());
        subject.setActive(true);
        subject.addTeacher(teacher);
    }

    @Override
    public void remove(int subjectId) {
        Subject subject = subjectDao.findById(subjectId);
        if (!Objects.isNull(subject)){
            subject.setActive(false);
            subjectDao.saveOrUpdate(subject);
        }

    }

    @Override
    public List<SubjectBean> getAllForTeacher(int teacherId) {
        return subjectDao.findAllForTeacher(teacherId).stream().map(SubjectBean::new).collect(Collectors.toList());
    }

    @Override
    public SubjectBean getById(int id) {
        return new SubjectBean(subjectDao.findById(id));
    }

    @Override
    public TeachersSubjectBean getExtendedById(int id) {
        return new TeachersSubjectBean(subjectDao.findById(id));
    }

    @Override
    public SubjectBean getByName(String name) {
        return new SubjectBean(subjectDao.findByName(name));
    }

    @Override
    public boolean isNameUnique(String name) {
        return null == getByName(name);
    }

    @Override
    public void addTeacherToSubject(int subjectId, int teacherId) {
        Subject subject = subjectDao.findById(subjectId);
        User user = userDao.findById(teacherId);

        if (Objects.isNull(subject) || Objects.isNull(user)){
            throw new IllegalArgumentException("Arguments can't be null!");
        }

        subject.addTeacher(user);
        subjectDao.saveOrUpdate(subject);
    }
}

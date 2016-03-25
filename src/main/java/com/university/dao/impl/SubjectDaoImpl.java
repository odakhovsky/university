package com.university.dao.impl;

import com.university.dao.SubjectDao;
import com.university.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {

    @Autowired private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(Subject subject) {
        getSession().saveOrUpdate(subject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subject> findAllForTeacher(int teacherId) {
        return getSession().createCriteria(Subject.class, "subject")
                .createAlias("subject.teaches" , "teacher")
                .add(
                        Restrictions.and(
                                Restrictions.eq("teacher.id", teacherId),
                                Restrictions.eq("subject.active", true))
                ).list();
    }

    @Override
    public Subject findByName(String name) {
        return (Subject) getSession().createCriteria(Subject.class, "subject").
                add(Restrictions.eq("subject.name", name))
                .uniqueResult();
    }

    @Override
    public Subject findById(int id) {
        return (Subject) getSession().createCriteria(Subject.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
}

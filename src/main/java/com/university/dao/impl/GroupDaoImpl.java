package com.university.dao.impl;

import com.university.dao.GroupDao;
import com.university.dao.SubjectDao;
import com.university.model.Group;
import com.university.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Repository
public class GroupDaoImpl implements GroupDao {

    @Autowired private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(Group group) {
        getSession().saveOrUpdate(group);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Group> findAllForTeacher(int teacherId) {
      return   getSession().createCriteria(Group.class, "group")
                .createAlias("group.subjects", "subject")
                .createAlias("subject.teaches", "teacher")
                .add(
                        Restrictions.and(
                                Restrictions.eq("teacher.id", teacherId),
                                Restrictions.eq("group.active", true),
                                Restrictions.eq("subject.active", true)
                        )
                ).list();
    }

    @Override
    public Group findByName(String name) {
        return (Group) getSession().createCriteria(Group.class, "group").
                add(Restrictions.eq("group.name", name))
                .uniqueResult();
    }

    @Override
    public Group findById(int id) {
        return (Group) getSession().createCriteria(Group.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

}

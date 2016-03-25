package com.university.service.impl;

import com.university.bean.GroupBean;
import com.university.dao.GroupDao;
import com.university.dao.UserDao;
import com.university.model.Group;
import com.university.service.GroupService;
import org.codehaus.jackson.map.ser.PropertyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Service
@Transactional
public class GroupServiceImpl implements GroupService{

    @Autowired private GroupDao groupDao;
    @Autowired private UserDao userDao;

    @Override
    public void create(String name) {
        if (StringUtils.isEmpty(name.trim())){
            throw new IllegalArgumentException("Group name should be not empty!");
        }

        Group group = new Group();
        group.setName(name);
        group.setActive(true);

        groupDao.saveOrUpdate(group);

        System.out.println(group);

    }

    @Override
    public List<GroupBean> getAllForTeacher(int teacherId) {
        return groupDao.findAllForTeacher(teacherId).stream().map(GroupBean::new).collect(Collectors.toList());
    }

    @Override
    public GroupBean getByName(String name) {
        return new GroupBean(groupDao.findByName(name));
    }

    @Override
    public GroupBean getById(int id) {
        return new GroupBean(groupDao.findById(id));
    }
}

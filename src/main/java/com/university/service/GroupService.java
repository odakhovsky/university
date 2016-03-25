package com.university.service;

import com.university.bean.GroupBean;
import com.university.model.Group;

import java.util.List;

/**
 * Created by volodymyrO on 25.03.16.
 */
public interface GroupService {
    void create(String name);
    List<GroupBean> getAllForTeacher(int teacherId);
    GroupBean getByName(String name);//todo in future get with ignore case
    GroupBean getById(int id);
}

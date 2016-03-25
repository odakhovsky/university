package com.university.bean.subject;

import com.university.bean.user.SimpleUserBean;
import com.university.model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class TeachersSubjectBean extends SubjectBean {
    private List<SimpleUserBean> teachers = new ArrayList<>();

    public TeachersSubjectBean(Subject subject){
        super(subject);
        if (!Objects.isNull(subject.getTeaches())){
            teachers.addAll(
                    subject.getTeaches().stream().map(SimpleUserBean::new).collect(Collectors.toList())
            );
        }
    }
}

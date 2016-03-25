package com.university.controller;

import com.university.bean.GroupBean;
import com.university.bean.subject.SubjectBean;
import com.university.bean.subject.TeachersSubjectBean;
import com.university.bean.user.UserBean;
import com.university.model.Group;
import com.university.model.Subject;
import com.university.service.GroupService;
import com.university.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Controller
@RequestMapping(value = "/classroom")
@SessionAttributes("userBean")
public class ClassroomController {

    @Autowired private GroupService groupService;
    @Autowired private SubjectService subjectService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap map, @ModelAttribute("userBean") UserBean teacher) {
        List<GroupBean> groups = groupService.getAllForTeacher(teacher.getId());
        map.addAttribute("groups", groups);
        return "classroom/classroom";
    }

    @RequestMapping(value = "/group/{groupId}/subject/{subjectId}" , method = RequestMethod.GET)
    public String groupSubjectDetails(ModelMap map,
                                        @PathVariable Integer groupId,
                                      @PathVariable Integer subjectId,
                                      @ModelAttribute("userBean")UserBean teacher){
        TeachersSubjectBean subject = subjectService.getExtendedById(subjectId);
        if (Objects.isNull(subject)){
            return "redirect:/classroom";
        }
        map.addAttribute("subject", subject);
        return "/classroom/subjects/details";
    }
}

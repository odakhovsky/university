package com.university.controller;

import com.university.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Controller
@RequestMapping(value = "/classroom")
public class ClassroomController {

    @Autowired private GroupService groupService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(){

        groupService.create("KC-12");
        return "classroom/classroom";
    }

}

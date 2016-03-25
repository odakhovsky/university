package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Controller
@RequestMapping(value = "/classroom")
public class ClassroomController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "classroom/classroom";
    }

}

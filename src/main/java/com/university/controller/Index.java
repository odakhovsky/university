package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by volodymyrO on 24.03.16.
 */
@Controller
public class Index {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}

package com.university.controller;

import com.university.bean.user.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by volodymyrO on 24.03.16.
 */
@Controller
@SessionAttributes("userBean")
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect(@ModelAttribute("userBean")UserBean userBean){
        switch (userBean.getRole()) {

            case ROLE_ADMIN:
                return "redirect:/";
            case ROLE_TEACHER:
                return "redirect:/classroom";//// TODO: 25.03.16
        }

        return "redirect:/";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}

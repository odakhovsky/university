package com.university.config.filter;

import com.university.bean.UserBean;
import com.university.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by volodymyrO on 25.03.16.
 */
@Component
public class AuthenticationSuccessFilter extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserBean userBean = userService.getUserByLogin(user.getUsername());
        request.getSession().setAttribute("userBean", userBean);

        request.getSession().setMaxInactiveInterval((int) TimeUnit.HOURS.toSeconds(48));
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
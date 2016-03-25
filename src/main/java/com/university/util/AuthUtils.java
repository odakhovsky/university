package com.university.util;

import com.university.model.Role;
import com.university.model.User;

/**
 * Created by volodymyrO on 25.03.16.
 */
public class AuthUtils {

    public static boolean hasRole(User user, Role.Name role){
        return user.getRole().getName().equals(role);
    }

}

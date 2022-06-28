package com.challenge.itau.users.service.impl;

import com.challenge.itau.config.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public interface UserSpringSecurityService {

    public static UserSpringSecurity authenticated() {
        try {
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

}

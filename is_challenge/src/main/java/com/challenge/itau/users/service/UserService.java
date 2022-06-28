package com.challenge.itau.users.service;

import com.challenge.itau.config.security.UserSpringSecurity;
import com.challenge.itau.users.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.List;

public interface UserService {

    User create(User user);
    void delete(Long id);
    User get(Long id);
    List<User> getAll();


    }





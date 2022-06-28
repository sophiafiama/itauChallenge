package com.challenge.itau.users.service;

import com.challenge.itau.users.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);
    void delete(Long id);
    User get(Long id);
    List<User> getAll();

}

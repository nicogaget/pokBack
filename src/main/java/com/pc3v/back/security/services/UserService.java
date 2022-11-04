package com.pc3v.back.security.services;

import com.pc3v.back.models.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findOne(int id);

    User findByUsername(String username);

    User save(User user);

}

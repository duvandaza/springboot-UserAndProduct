package com.duvan.curso.springboot.app.springbootcrudjpa.services;

import java.util.List;

import com.duvan.curso.springboot.app.springbootcrudjpa.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    boolean existsByUsername(String username);
}

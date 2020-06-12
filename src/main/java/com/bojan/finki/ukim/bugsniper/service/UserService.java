package com.bojan.finki.ukim.bugsniper.service;

import com.bojan.finki.ukim.bugsniper.model.Task;
import com.bojan.finki.ukim.bugsniper.model.User;

import java.util.List;

public interface UserService {
    User save(User user);
    User findById(Long id);
    List<User> findAll();
    void deleteById(Long id);
}

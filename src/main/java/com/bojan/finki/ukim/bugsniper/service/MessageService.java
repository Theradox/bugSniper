package com.bojan.finki.ukim.bugsniper.service;

import com.bojan.finki.ukim.bugsniper.model.Message;
import com.bojan.finki.ukim.bugsniper.model.User;

import java.util.List;

public interface MessageService {
    Message save(Message user);
    Message findById(Long id);
    List<Message> findAll();
    void deleteById(Long id);
}

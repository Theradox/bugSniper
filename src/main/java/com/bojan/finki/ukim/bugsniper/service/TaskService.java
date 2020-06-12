package com.bojan.finki.ukim.bugsniper.service;

import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.Task;

import java.util.List;

public interface TaskService {
    Task save(Task task);
    Task save(String message, Long categoryId);
    Task findById(Long id);
    List<Task> findAll();
    void deleteById(Long id);


}

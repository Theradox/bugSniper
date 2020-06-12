package com.bojan.finki.ukim.bugsniper.service;

import java.util.List;

public interface TaskGroupService {
    TaskGroupService save(TaskGroupService taskGroup);
    TaskGroupService findById(Long id);
    List<TaskGroupService> findAll();
    void deleteById(Long id);
}

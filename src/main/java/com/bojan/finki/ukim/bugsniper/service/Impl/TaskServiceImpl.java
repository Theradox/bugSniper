package com.bojan.finki.ukim.bugsniper.service.Impl;

import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.Task;

import com.bojan.finki.ukim.bugsniper.model.exception.CategoryNotFoundException;
import com.bojan.finki.ukim.bugsniper.model.exception.TaskNotFoundException;
import com.bojan.finki.ukim.bugsniper.repository.CategoryRepostiory;
import com.bojan.finki.ukim.bugsniper.repository.TaskRepository;
import com.bojan.finki.ukim.bugsniper.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final CategoryRepostiory categoryRepostiory;
    public TaskServiceImpl(TaskRepository taskRepository, CategoryRepostiory categoryRepostiory) {
        this.taskRepository = taskRepository;
        this.categoryRepostiory = categoryRepostiory;
    }

    @Override
    public Task save(@Valid @RequestBody Task task) {
//        Category category = this.categoryRepostiory.findById(task.getCategory().getId())
//                .orElseThrow(()->new CategoryNotFoundException(task.getCategory().getId()));
//
        return this.taskRepository.save(task);
    }

    @Override
    public Task update(@RequestParam Long id, @RequestParam String message, @RequestParam Long categoryId) {
                Category category = this.categoryRepostiory.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));

                Task task = this.taskRepository.findById(id)
                        .orElseThrow(()-> new TaskNotFoundException(id));
                task.setCategory(category);
                task.setMessage(message);
                return this.taskRepository.save(task);

    }

    @Override
    public Task findById(Long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
            //Task task = this.taskRepository.findById(id);
        this.taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAllByCategory_Id(Long id) {
        return this.taskRepository.findAllByCategory_Id(id);
    }

}

package com.bojan.finki.ukim.bugsniper.web;


import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.Task;
import com.bojan.finki.ukim.bugsniper.model.exception.CategoryNotFoundException;
import com.bojan.finki.ukim.bugsniper.repository.CategoryRepostiory;
import com.bojan.finki.ukim.bugsniper.service.Impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskRestController {
    private final TaskServiceImpl taskService;
    private final CategoryRepostiory categoryRepostiory; // napravi service

    public TaskRestController(TaskServiceImpl taskService,
                              CategoryRepostiory categoryRepostiory) {
        this.taskService = taskService;
        this.categoryRepostiory = categoryRepostiory;
    }


    // tuka ke treba da se napravi za sekoj user specificno
    @GetMapping("")
    private List<Task> allTasks(){
            return this.taskService.findAll();
    }
    @GetMapping("/{taskId}")
    private Task getTaskById(@PathVariable Long taskId){
        return this.taskService.findById(taskId);
    }

    @PostMapping("")
    private Task saveTask(@Valid @RequestBody Task task){
        return this.taskService.save(task);
    }

//    @PostMapping("/postask")
//    private Task saveTask(String message, Long categoryId){
//        Category category = this.categoryRepostiory.findById(categoryId)
//                .orElseThrow(()->new CategoryNotFoundException(categoryId));
//        Task task = new Task(message, category);
//
//        return this.taskService.save(task);
//    }

}

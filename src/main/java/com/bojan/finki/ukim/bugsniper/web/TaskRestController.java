package com.bojan.finki.ukim.bugsniper.web;


import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.Task;
import com.bojan.finki.ukim.bugsniper.model.exception.CategoryNotFoundException;
import com.bojan.finki.ukim.bugsniper.repository.CategoryRepostiory;
import com.bojan.finki.ukim.bugsniper.service.Impl.CategoryServiceImpl;
import com.bojan.finki.ukim.bugsniper.service.Impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskRestController {
    private final TaskServiceImpl taskService;
    private final CategoryServiceImpl categoryService; // napravi service

    public TaskRestController(TaskServiceImpl taskService,
                              CategoryServiceImpl categoryService) {
        this.taskService = taskService;
        this.categoryService = categoryService;
    }


    // tuka ke treba da se napravi za sekoj user specificno
    @GetMapping("")
    private List<Task> allTasks() {
        return this.taskService.findAll();
    }

    @GetMapping("/{taskId}")
    private Task getTaskById(@PathVariable Long taskId) {
        try{
            Task task = this.taskService.findById(taskId);
        } catch (Exception e) {
            e.getMessage();
        }
        return this.taskService.findById(taskId);
    }

    @PostMapping("")
    private Task saveTask(@Valid @RequestBody Task task) {
        return this.taskService.save(task);
    }

    @PatchMapping("")
    private Task updateTask(@RequestParam Long id, @RequestParam String message, @RequestParam Long categoryId) {
//        Category category = this.categoryService.getById(categoryId);
//        Task task = this.taskService.findById(id);
//        task.setCategory(category);
//        task.setMessage(message);
        return this.taskService.update(id, message, categoryId);
    }

    @DeleteMapping("/{taskId}")
    private void deleteTask(@PathVariable Long taskId) {
        this.taskService.deleteById(taskId);
    }
    @GetMapping("/byCategory/{categoryId}")
    private List<Task> findAllByCategoryId(@PathVariable Long id){
        return this.taskService.findAllByCategory_Id(id);
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

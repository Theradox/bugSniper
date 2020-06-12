package com.bojan.finki.ukim.bugsniper.web;


import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.service.Impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryRestController {
    private final CategoryServiceImpl categoryService;

    public CategoryRestController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    private Category saveCategory(@Valid @RequestBody Category category){
        return this.categoryService.save(category);
    }


    @DeleteMapping("/{categoryId}")
    private void deleteCategory(@PathVariable Long categoryId){
        this.categoryService.deleteById(categoryId);
    }

    @PatchMapping("")
    private Category updateCategory(@RequestParam Long id, @RequestParam String description){
        return this.categoryService.update(id, description);


    }

    @GetMapping("/{categoryId}")
    private Category findByid(@PathVariable Long categoryId){
        try{
            Category category = this.categoryService.findById(categoryId);


        } catch (Exception e) {
            e.getMessage();
        }
        return this.categoryService.findById(categoryId);

    }

    @GetMapping("")
    private List<Category> getCategories(){
        return  this.categoryService.getAll();
    }
}

package com.bojan.finki.ukim.bugsniper.service.Impl;


import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.User;
import com.bojan.finki.ukim.bugsniper.model.exception.CategoryNotFoundException;
import com.bojan.finki.ukim.bugsniper.repository.CategoryRepostiory;
import com.bojan.finki.ukim.bugsniper.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepostiory categoryRepostiory;

    public CategoryServiceImpl(CategoryRepostiory categoryRepostiory) {
        this.categoryRepostiory = categoryRepostiory;
    }

    @Override
    public Category save(@Valid @RequestBody Category category) {
        return this.categoryRepostiory.save(category);
    }

    @Override
    public void deleteById(Long id) {
        Category category = this.categoryRepostiory.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepostiory.findById(id)
                .orElseThrow(()->new CategoryNotFoundException(id));
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepostiory.findAll();
    }

    @Override
    public Category update(@RequestParam Long id, @RequestParam String description) {
        Category category = this.categoryRepostiory.findById(id)
                .orElseThrow(()-> new CategoryNotFoundException(id));
        category.setDescription(description);
        return this.categoryRepostiory.save(category);
    }
}

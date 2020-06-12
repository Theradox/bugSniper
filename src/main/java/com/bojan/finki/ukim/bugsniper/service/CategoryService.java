package com.bojan.finki.ukim.bugsniper.service;

import com.bojan.finki.ukim.bugsniper.model.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    void deleteById(Long id);
    Category findById(Long id);
    List<Category> getAll();
    Category update(Long id, String description);
}

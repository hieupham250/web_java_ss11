package com.example.ss11.service;

import com.example.ss11.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    boolean existsByCategoryName(String name);
    void editCategory(Category category);
    boolean deleteCategory(int id);
}

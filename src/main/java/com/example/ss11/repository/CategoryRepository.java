package com.example.ss11.repository;

import com.example.ss11.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    void save(Category category);
    boolean existsByCategoryName(String name);
    void editCategory(Category category);
    boolean deleteCategory(int id);
}

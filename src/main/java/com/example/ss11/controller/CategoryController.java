package com.example.ss11.controller;

import com.example.ss11.dto.CategoryDTO;
import com.example.ss11.model.Category;
import com.example.ss11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showCategoryList(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categories", categoryList);
        return "listCategory";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO,
                              BindingResult result,
                              Model model) {
        if (categoryService.existsByCategoryName(categoryDTO.getCategoryName())) {
            result.rejectValue("categoryName", "error.category", "Tên danh mục đã tồn tại");
        }

        if (result.hasErrors()) {
            return "addCategory";
        }

        // Chuyển đổi DTO sang Entity
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setStatus(categoryDTO.isStatus());

        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit")
    public String showEditForm(int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }

        // Chuyển từ entity sang DTO
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setCategoryName(category.getCategoryName());
        dto.setStatus(category.isStatus());

        model.addAttribute("category", dto);
        return "editCategory";
    }

    @PostMapping("/edit")
    public String updateCategory(@Valid @ModelAttribute("category") CategoryDTO categoryDTO,
                                 BindingResult result,
                                 Model model) {

        Category existing = categoryService.findById(categoryDTO.getId());
        if (existing == null) {
            return "redirect:/categories";
        }

        if (!existing.getCategoryName().equals(categoryDTO.getCategoryName())
                && categoryService.existsByCategoryName(categoryDTO.getCategoryName())) {
            result.rejectValue("categoryName", "error.category", "Tên danh mục đã tồn tại");
        }

        if (result.hasErrors()) {
            return "editCategory";
        }

        // Cập nhật thông tin
        existing.setCategoryName(categoryDTO.getCategoryName());
        existing.setStatus(categoryDTO.isStatus());

        categoryService.editCategory(existing);
        return "redirect:/categories";
    }


    @GetMapping("/delete")
    public String deleteCategory(int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}

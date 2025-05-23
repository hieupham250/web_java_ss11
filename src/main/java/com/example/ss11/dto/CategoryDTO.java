package com.example.ss11.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CategoryDTO {
    private int id;
    @NotBlank(message = "Tên danh mục không được để trống")
    @Size(max = 50, message = "Tên danh mục tối đa 50 ký tự")
    private String categoryName;
    private boolean status;
}

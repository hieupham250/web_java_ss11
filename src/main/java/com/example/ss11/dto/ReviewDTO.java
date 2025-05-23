package com.example.ss11.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ReviewDTO {
    @NotNull(message = "Tên không được để trống")
    private String name;

    @NotNull(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotNull(message = "Vui lòng chọn đánh giá")
    @Min(value = 1, message = "Đánh giá tối thiểu là 1 sao")
    @Max(value = 5, message = "Đánh giá tối đa là 5 sao")
    private Integer rating;

    @Size(max = 200, message = "Bình luận tối đa 200 ký tự")
    private String comment;
}

package com.example.ss11.dto;

import com.example.ss11.validator.ValidEmail;
import com.example.ss11.validator.ValidPassword;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegistrationDTO {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @ValidEmail
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @ValidPassword
    private String password;
}

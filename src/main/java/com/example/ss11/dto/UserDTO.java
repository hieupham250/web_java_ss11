package com.example.ss11.dto;


import com.example.ss11.validator.ValidPhone;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @NotNull
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;

    @NotNull @NotBlank
    @Email
    private String email;

    @NotNull @ValidPhone
    private String phone;

    @NotNull @NotBlank
    private String password;

    private boolean status;
}

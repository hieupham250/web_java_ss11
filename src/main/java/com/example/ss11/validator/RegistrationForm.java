package com.example.ss11.validator;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationForm {
    public interface UserGroup {}
    public interface AdminGroup extends UserGroup {}

    @NotBlank(message = "Tên không được để trống", groups = {UserGroup.class, AdminGroup.class})
    private String name;

    @NotBlank(message = "Email không được để trống", groups = {UserGroup.class, AdminGroup.class})
    @Email(message = "Email không hợp lệ", groups = {UserGroup.class, AdminGroup.class})
    private String email;

    @NotNull(message = "Vai trò không được để trống", groups = {UserGroup.class, AdminGroup.class})
    @Pattern(regexp = "admin|user", message = "Vai trò phải là admin hoặc user", groups = {UserGroup.class, AdminGroup.class})
    private String role;

    @NotBlank(message = "Admin code không được để trống", groups = AdminGroup.class)
    private String adminCode;
}

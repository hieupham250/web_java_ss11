package com.example.ss11.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;

        if (password.length() < 8) return false;

        if (!password.matches(".*[A-Z].*")) return false;

        if (!password.matches(".*[a-z].*")) return false;

        if (!password.matches(".*\\d.*")) return false;

        if (!password.matches(".*[!@#$%^&*()-+=].*")) return false;

        return true;
    }
}


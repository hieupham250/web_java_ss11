package com.example.ss11.controller;

import com.example.ss11.validator.RegistrationForm;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationControllerB5 {
    @GetMapping("registerB5")
    public String showForm(Model model) {
        model.addAttribute("form", new RegistrationForm());
        return "registerB5";
    }

    @PostMapping("registerB5")
    public String submitForm(@ModelAttribute("form") RegistrationForm form, BindingResult result) {
        Class<?> validationGroup = form.getRole() != null && form.getRole().equals("admin")
                ? RegistrationForm.AdminGroup.class
                : RegistrationForm.UserGroup.class;

        javax.validation.Validator validator = javax.validation.Validation.buildDefaultValidatorFactory().getValidator();
        var violations = validator.validate(form, validationGroup);

        if (!violations.isEmpty()) {
            for (var violation : violations) {
                String propertyPath = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                result.rejectValue(propertyPath, "", message);
            }
        }

        if (result.hasErrors()) {
            return "registerB5";
        }

        return "result";
    }
}

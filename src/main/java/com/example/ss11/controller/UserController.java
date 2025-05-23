package com.example.ss11.controller;

import com.example.ss11.dto.UserDTO;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @GetMapping("form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "form";
    }

    @PostMapping("submit")
    public String submitForm(@ModelAttribute("user") @Valid UserDTO user,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        return "result";
    }
}

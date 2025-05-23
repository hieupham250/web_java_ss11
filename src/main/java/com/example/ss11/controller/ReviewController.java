package com.example.ss11.controller;

import com.example.ss11.dto.ReviewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ReviewController {
    @GetMapping("/review")
    public String showForm(Model model) {
        model.addAttribute("review", new ReviewDTO());
        return "reviewForm"; // trả về JSP reviewForm.jsp
    }

    @PostMapping("/review")
    public String submitForm(@Valid @ModelAttribute("review") ReviewDTO review,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            return "reviewForm";
        }
        model.addAttribute("message", "Cảm ơn bạn đã đánh giá!");
        return "reviewSuccess";
    }
}

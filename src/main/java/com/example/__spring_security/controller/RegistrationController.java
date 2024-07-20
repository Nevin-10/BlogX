package com.example.__spring_security.controller;

import com.example.__spring_security.DTO.UserRegistrationDto;
import com.example.__spring_security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new UserRegistrationDto());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView registerUser(@Valid @ModelAttribute("user") UserRegistrationDto userRegistrationDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("register", "formErrors", result.getAllErrors());
        }

        userService.registerUser(userRegistrationDto);
        return new ModelAndView("redirect:/login-page");
    }
}

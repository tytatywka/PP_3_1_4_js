package com.example.andreyrestjs.controllers;

import com.example.andreyrestjs.models.User;
import com.example.andreyrestjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PornRestController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public PornRestController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/porn/{age}")
    public String checkAge(@PathVariable("age") int age, User user, Model model) {
        model.addAttribute("user", userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()));
        return "porn";
    }
}

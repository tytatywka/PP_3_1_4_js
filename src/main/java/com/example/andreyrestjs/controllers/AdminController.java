package com.example.andreyrestjs.controllers;

import com.example.andreyrestjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String getUserInfo(Model model) {
        model.addAttribute("user", userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()));
        return "admin";
    }

}

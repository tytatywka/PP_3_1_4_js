package com.example.andreyrestjs.controllers;

import com.example.andreyrestjs.models.User;
import com.example.andreyrestjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserControllerRest {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserControllerRest(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public ResponseEntity<User> user() {
        return new ResponseEntity<>(userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()), HttpStatus.OK);
    }

}

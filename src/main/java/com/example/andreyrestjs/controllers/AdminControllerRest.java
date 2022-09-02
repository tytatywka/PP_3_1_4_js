package com.example.andreyrestjs.controllers;

import com.example.andreyrestjs.models.User;
import com.example.andreyrestjs.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminControllerRest {

    private final UserServiceImpl userServiceImpl;


    @Autowired
    public AdminControllerRest(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> allUsersRest() {
        return new ResponseEntity<>(userServiceImpl.listUser(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<User> navBar() {
        return new ResponseEntity<>(userServiceImpl.findByUsername(userServiceImpl.getCurrentUsername()), HttpStatus.OK);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<User> update(@PathVariable("id") int id, @RequestBody User user) {
        String oldPass = userServiceImpl.getUserById(id).getPassword();
        if (oldPass.equals(user.getPassword())) {
            user.setPassword(oldPass);
            userServiceImpl.updateUser(user);
        } return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("admin/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") int id) {
        userServiceImpl.removeUser(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}

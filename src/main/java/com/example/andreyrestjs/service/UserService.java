package com.example.andreyrestjs.service;

import com.example.andreyrestjs.models.User;

import java.util.List;

public interface UserService {
    List<User> listUser ();
    User getUserById (int id);
    void addUser (User user);
    void removeUser (int id);
    void updateUser (User user);

}

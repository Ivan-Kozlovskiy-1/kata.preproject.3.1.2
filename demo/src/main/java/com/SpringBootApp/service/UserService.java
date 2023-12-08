package com.SpringBootApp.service;


import com.SpringBootApp.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User getUserById(Long id);
}

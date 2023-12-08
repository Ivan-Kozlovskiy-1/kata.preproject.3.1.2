package com.SpringBootApp.controller;

import com.SpringBootApp.model.User;
import com.SpringBootApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;


import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private UserService userService;


    @GetMapping("/users")
    public String usersList(Model model) {
        model.addAttribute("userList", userService.allUsers());
        return "users";
    }

    @GetMapping(value = "/users/edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PutMapping(value = "/users/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/users/add")
    public String addPage(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }
    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/users/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }
}
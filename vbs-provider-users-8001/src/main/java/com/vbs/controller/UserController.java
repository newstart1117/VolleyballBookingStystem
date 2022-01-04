package com.vbs.controller;

import com.vbs.model.User;
import com.vbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/user/{id}")
    public Optional<User> user(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}

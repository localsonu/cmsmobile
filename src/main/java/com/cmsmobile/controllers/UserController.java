package com.cmsmobile.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmsmobile.model.User;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestBody User user){
        return new User();
    }
    
    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return new User();
    }
}

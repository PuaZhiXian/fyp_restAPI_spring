package com.example.fyp_restapi_spring.api.controller;

import com.example.fyp_restapi_spring.api.beans.User;
import com.example.fyp_restapi_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam String id){
return userService.getUserById(id);
    }

}

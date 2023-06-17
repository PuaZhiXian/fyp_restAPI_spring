package com.example.fyp_restapi_spring.service;

import com.example.fyp_restapi_spring.api.beans.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user = new User("name", "id");
        userList.add(user);
    }

    public User getUserById(String id) {
        return userList.get(0);
    }
}

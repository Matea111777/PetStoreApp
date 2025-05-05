package com.example.petstore.web;

import com.example.petstore.model.User;
import com.example.petstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
 private final UserService userService;
    @PostMapping("/create-users")
    public void createUsers() {
        userService.createUsers();
    }

    @GetMapping("/list-users")
    public List<User> listUsers() {
        return userService.getAllUsers();
    }

}

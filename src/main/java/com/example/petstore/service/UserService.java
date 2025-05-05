package com.example.petstore.service;

import com.example.petstore.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    void createUsers();
    List<User> getAllUsers();
}

package com.example.petstore.service.Impl;

import com.example.petstore.model.User;
import com.example.petstore.repository.UserRepository;
import com.example.petstore.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    private final Random random = new Random();
    @Override
    public void createUsers() {
        if (userRepo.count() >= 10) return;

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setFirstName("First" + i);
            user.setLastName("Last" + i);
            user.setEmailAddress("user" + i + "@mail.com");
            user.setBudget(BigDecimal.valueOf(5 + random.nextInt(10)));
            userRepo.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}

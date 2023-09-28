package com.example.gymapp.service;

import com.example.gymapp.model.User;
import com.example.gymapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository repository;

    public void save(User user) {
        repository.save(user);
    }


    public void delete(User user) {
        repository.delete(user);
    }
}

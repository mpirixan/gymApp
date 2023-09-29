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

    public void update(Long id, User user){

    }
    public User getUser(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public void deleteUser(Long id) {

        repository.deleteById(id);
    }
}

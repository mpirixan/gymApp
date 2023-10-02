package com.example.gymapp.service;

import com.example.gymapp.model.User;
import com.example.gymapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void save(User user) {
        User userModel = new User();
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setUsername(user.getUsername());
        userModel.setPhone(user.getPhone());

        repository.save(userModel);
    }

    public List<User> getUsers() {
      return repository.findAll();
    }
    public void update(Long id, User user){
        // TODO document why this method is empty
    }
    public User getUser(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    public User getUser(Long id) {
        return repository.findById(id).get();
    }
    public void deleteUser(Long id) {

        repository.deleteById(id);
    }
}

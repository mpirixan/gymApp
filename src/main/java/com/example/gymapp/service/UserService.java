package com.example.gymapp.service;

import com.example.gymapp.config.exception.ServiceException;
import com.example.gymapp.model.User;
import com.example.gymapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void update(User user){
       Optional <User> userModel = repository.findById(user.getId());
            if (!userModel.isPresent()){
                throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
            }
       repository.save(user);
    }
    public User getUser(String email, String password) {
        User userModel = repository.findByEmailAndPassword(email, password);
        if (userModel == null){
            throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
        }
        return repository.findByEmailAndPassword(email, password);
    }
    public User getUser(String email){
        return repository.findByEmail(email);
    }

    public User getUser(Long id) {
        return repository.findById(id).get();
    }
    public void deleteUser(Long id) {

        repository.deleteById(id);
    }
}

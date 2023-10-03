package com.example.gymapp.service;

import com.example.gymapp.config.exception.ServiceException;
import com.example.gymapp.model.User;
import com.example.gymapp.model.dto.RequestCredentialsDto;
import com.example.gymapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public void save(User user) {
        Optional<User> userCheck = repository.findByEmail(user.getEmail());
        if (userCheck.isPresent()){
            throw new ServiceException("User already exists", HttpStatus.CONFLICT);
        }
        User userModel = new User();
        userModel.setEmail(user.getEmail());
        userModel.setPassword(bcrypt.encode(user.getPassword()));
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
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
       repository.save(user);
    }
    public User getUser(String email, String password) {
        Optional<User> userModel = repository.findByEmail(email);
        if (!userModel.isPresent()){
            throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
        }
        if (!bcrypt.matches(password, userModel.get().getPassword())){
            throw new ServiceException("Password does not match", HttpStatus.FORBIDDEN);
        }
        return userModel.get();
    }

    public void deleteUser(RequestCredentialsDto credentials) {
        User user = this.getUser(credentials.getEmail(), credentials.getPassword());
        repository.delete(user);
    }
}

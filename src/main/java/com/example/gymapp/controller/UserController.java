package com.example.gymapp.controller;

import com.example.gymapp.model.User;
import com.example.gymapp.model.dto.RequestCredentialsDto;
import com.example.gymapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping()
    public ResponseEntity newUser(@RequestBody User user) {
        service.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("userEdit")
    public void editUser(@RequestBody  User user) {
        service.update(user);
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<User> getUser(@PathVariable
                                        ("email") String email,
                                         @PathVariable("password") String password)
        {
            return ResponseEntity.ok(service.getUser(email, password));
        }

        @GetMapping
        public List<User> getUsers() {
            return service.getUsers();
        }
    @DeleteMapping()
    public void deleteUser(@RequestBody RequestCredentialsDto credentialsDto) {
        service.deleteUser(credentialsDto);
    }
}

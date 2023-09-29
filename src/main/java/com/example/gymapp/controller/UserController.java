package com.example.gymapp.controller;

import com.example.gymapp.model.User;
import com.example.gymapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private UserService service;


    @PostMapping("newUser")
    public void newUser(@RequestBody User user) {
        service.save(user);
    }

    @PutMapping("userEdit/{id}")
    public void editUser(@PathVariable Long id,
                         @RequestBody  User user) {
        service.update(id,user);
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<User> getUser(@PathVariable
                                        ("email") String email,
                                         @PathVariable("password") String password)
        {
            return ResponseEntity.ok(service.getUser(email, password));
        }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        service.deleteUser(id);
    }
}

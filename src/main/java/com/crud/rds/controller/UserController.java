package com.crud.rds.controller;


import com.crud.rds.Repository.UserRepository;
import com.crud.rds.entity.user_details;
import com.crud.rds.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://savithadesigns.com")
public class UserController {

    @Autowired
    UserRepository userRepository;

    user_details user;

    @PostMapping("/add")
    public user_details addUser(@RequestBody user_details user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<user_details> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    user_details getUserById(@PathVariable int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping("/update/{id}")
    public user_details updateUser(@RequestBody user_details newUser, @PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUser_name(newUser.getUser_name());
                    user.setAge(newUser.getAge());
                    user.setAddress(newUser.getAddress());
                    user.setCity(newUser.getCity());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " deleted successfully!";
    }
}
package com.fortytwo.userstorage.web;

import com.fortytwo.userstorage.model.User;
import com.fortytwo.userstorage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/")
    public User addUser (@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}

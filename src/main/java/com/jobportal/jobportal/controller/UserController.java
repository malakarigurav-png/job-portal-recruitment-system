package com.jobportal.jobportal.controller;

import com.jobportal.jobportal.entity.User;
import com.jobportal.jobportal.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
} 
    @PostMapping("/login")
public User login(@RequestBody User loginUser) {

    User user = userService.getUserByEmail(loginUser.getEmail());

    if (user != null && user.getPassword().equals(loginUser.getPassword())) {
        return user;
    }

    throw new RuntimeException("Invalid email or password");
} 
}
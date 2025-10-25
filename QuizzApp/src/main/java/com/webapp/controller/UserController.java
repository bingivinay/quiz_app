package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.beans.student;
import com.webapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody student student) {
        return userService.registerUser(student);
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(
            @RequestParam String email,
            @RequestParam String password) {
        return userService.loginUser(email, password);
    }
}

package com.webapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webapp.beans.student;
import com.webapp.dao.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

   
    public ResponseEntity<String> registerUser(student student) {
        student existingUser = userRepository.findByEmail(student.getEmail());
        if (existingUser != null) {
            return new ResponseEntity<>("Email already exists!", HttpStatus.BAD_REQUEST);
        }
        userRepository.save(student);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

  
    public ResponseEntity<String> loginUser(String email, String password) {
        student user = userRepository.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("Invalid email!", HttpStatus.UNAUTHORIZED);
        }

        if (!user.getPassword().equals(password)) {
            return new ResponseEntity<>("Invalid password!", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Login successful!", HttpStatus.OK);
    }
}

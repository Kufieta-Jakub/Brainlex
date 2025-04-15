package com.example.brainlex.controller;

import com.example.brainlex.model.UserDTO;
import com.example.brainlex.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public UserDTO addUser(@RequestBody UserDTO user) {
            return userRepository.save(user);
    }
}

package com.example.brainlex.controller;

import com.example.brainlex.model.UserDTO;
import com.example.brainlex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LoggingController{

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserService userService;

    public LoggingController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO user)
    {
        Optional<UserDTO> optionalUser = userService.getUserByEmail(user.getEmail());
        if(optionalUser.isPresent()) {
            UserDTO foundUser = optionalUser.get();
            String encodedPasswordInDb = foundUser.getPassword();

            if(passwordEncoder.matches(user.getPassword(),encodedPasswordInDb))
            {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}





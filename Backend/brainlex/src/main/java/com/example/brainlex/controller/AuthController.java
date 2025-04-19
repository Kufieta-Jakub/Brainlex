package com.example.brainlex.controller;

import com.example.brainlex.security.JwtUtil;
import com.example.brainlex.model.UserDTO;  // Model danych logowania
import com.example.brainlex.service.UserServiceImpl;  // Usługa do weryfikacji użytkownika
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDTO loginRequest) {
        Optional<UserDTO> optionalUser = userServiceImpl.getUserByEmail(loginRequest.getEmail());

        if (optionalUser.isPresent()) {
            UserDTO foundUser = optionalUser.get();

            if (passwordEncoder.matches(loginRequest.getPassword(), foundUser.getPassword())) {
                String token = jwtUtil.generateToken(foundUser.getEmail());
                return ResponseEntity.ok(new LoginResponse(token));
            } else {
                return ResponseEntity.status(401).body(Map.of("error", "Incorrect password"));
            }
        } else {
            return ResponseEntity.status(404).body(Map.of("error", "User not found"));
        }
    }
}

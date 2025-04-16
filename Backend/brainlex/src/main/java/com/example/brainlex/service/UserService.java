package com.example.brainlex.service;

import com.example.brainlex.model.UserDTO;
import com.example.brainlex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void registerUser(String plainPassword) {
        String encodePassword = passwordEncoder.encode(plainPassword);
    }

    public boolean verifyPassword(String rawPassword, String encodePasswordFromDb){
        return passwordEncoder.matches(rawPassword,encodePasswordFromDb);
    }

    public Optional<UserDTO> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}

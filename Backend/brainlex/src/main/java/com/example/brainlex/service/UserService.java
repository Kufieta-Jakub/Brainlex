package com.example.brainlex.service;

import com.example.brainlex.model.UserDTO;
import com.example.brainlex.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<UserDTO> getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }

}

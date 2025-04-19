package com.example.brainlex.service;

import com.example.brainlex.model.UserDTO;
import java.util.Optional;

public interface UserService {
    Optional<UserDTO> getUserByEmail(String email);
    boolean authenticateUser(String email, String rawPassword);
}


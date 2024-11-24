package com.rentiT.userMs.service;

import com.rentiT.userMs.dto.UserRequestDTO;
import com.rentiT.userMs.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser (UserRequestDTO userRequestDTO);
    UserResponseDTO getUserById (Long id);
    UserResponseDTO updateUser (Long id, UserRequestDTO userRequestDTO);
    void deleteUser(Long id);
}

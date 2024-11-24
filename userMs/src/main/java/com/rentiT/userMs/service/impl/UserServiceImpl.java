package com.rentiT.userMs.service.impl;

import com.rentiT.userMs.dto.UserRequestDTO;
import com.rentiT.userMs.dto.UserResponseDTO;
import com.rentiT.userMs.exception.UserNotFoundException;
import com.rentiT.userMs.model.User;
import com.rentiT.userMs.repository.UserRepository;
import com.rentiT.userMs.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;




public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;        //for mappping between user and userDTO
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setLocation(userRequestDTO.getLocation());
        user.setPassword(userRequestDTO.getPassword());
        user.setOrganization(userRequestDTO.getOrganization());
        user.setPreferences(userRequestDTO.getPreferences());

        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id " + id));
        user.setName(userRequestDTO.getName());
        user.setLocation(userRequestDTO.getLocation());
        user.setOrganization(userRequestDTO.getOrganization());
        user.setPreferences(userRequestDTO.getPreferences());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

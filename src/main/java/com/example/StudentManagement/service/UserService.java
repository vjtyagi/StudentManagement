package com.example.StudentManagement.service;

import java.util.List;

import com.example.StudentManagement.dto.CreateUserDTO;
import com.example.StudentManagement.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(CreateUserDTO userDTO);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO updateUser(Long id, CreateUserDTO userDTO);

    void deleteUser(Long id);

    UserResponseDTO linkRole(Long id, String roleName);

}

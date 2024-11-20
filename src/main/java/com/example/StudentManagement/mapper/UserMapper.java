package com.example.StudentManagement.mapper;

import org.springframework.stereotype.Component;

import com.example.StudentManagement.dto.CreateUserDTO;
import com.example.StudentManagement.dto.UserResponseDTO;
import com.example.StudentManagement.entity.User;

@Component
public class UserMapper {
    public User toEntity(CreateUserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserResponseDTO toDto(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setUsername(user.getUsername());
        return userResponseDTO;
    }
}

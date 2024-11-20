package com.example.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CreateUserDTO;
import com.example.StudentManagement.dto.UserResponseDTO;
import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.mapper.UserMapper;
import com.example.StudentManagement.repository.RoleRepository;
import com.example.StudentManagement.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(CreateUserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDto(user);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> usersList = new ArrayList<>();
        for (User user : users) {
            usersList.add(userMapper.toDto(user));
        }
        return usersList;
    }

    @Override
    public UserResponseDTO updateUser(Long id, CreateUserDTO userDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setUsername(userDTO.getUsername());
        if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        }
        User updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponseDTO linkRole(Long id, String roleName) {
        Role studentRole = roleRepository.findByName(roleName);
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.addRole(studentRole);
        User updatedUser = userRepository.save(user);
        return userMapper.toDto(updatedUser);
    }

}

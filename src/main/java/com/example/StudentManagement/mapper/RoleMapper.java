package com.example.StudentManagement.mapper;

import org.springframework.stereotype.Component;

import com.example.StudentManagement.dto.CreateRoleDTO;
import com.example.StudentManagement.dto.RoleResponseDTO;
import com.example.StudentManagement.entity.Role;

@Component
public class RoleMapper {
    public Role toEntity(CreateRoleDTO roleDTO) {
        Role role = new Role();
        role.setName(roleDTO.getName());
        return role;
    }

    public RoleResponseDTO toDto(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setName(role.getName());
        roleResponseDTO.setId(role.getId());
        return roleResponseDTO;
    }
}

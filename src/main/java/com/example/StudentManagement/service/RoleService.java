package com.example.StudentManagement.service;

import java.util.List;

import com.example.StudentManagement.dto.CreateRoleDTO;
import com.example.StudentManagement.dto.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO createRole(CreateRoleDTO createRoleDTO);

    RoleResponseDTO getRoleById(Integer id);

    List<RoleResponseDTO> getAllRoles();

    RoleResponseDTO updateRole(Integer id, CreateRoleDTO roleDTO);

    void deleteRole(Integer id);
}

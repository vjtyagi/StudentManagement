package com.example.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CreateRoleDTO;
import com.example.StudentManagement.dto.RoleResponseDTO;
import com.example.StudentManagement.entity.Role;
import com.example.StudentManagement.mapper.RoleMapper;
import com.example.StudentManagement.repository.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleResponseDTO createRole(CreateRoleDTO createRoleDTO) {
        Role role = roleRepository.save(roleMapper.toEntity(createRoleDTO));
        return roleMapper.toDto(role);
    }

    @Override
    public RoleResponseDTO getRoleById(Integer id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role Not Found"));
        return roleMapper.toDto(role);
    }

    @Override
    public List<RoleResponseDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleResponseDTO> rolesList = new ArrayList<>();
        for (Role role : roles) {
            rolesList.add(roleMapper.toDto(role));
        }
        return rolesList;
    }

    @Override
    public RoleResponseDTO updateRole(Integer id, CreateRoleDTO roleDTO) {
        Role existingRole = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role Not Found"));
        existingRole.setName(roleDTO.getName());
        Role updatedRole = roleRepository.save(existingRole);
        return roleMapper.toDto(updatedRole);
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

}

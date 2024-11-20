package com.example.StudentManagement.dto;

public class CreateRoleDTO {
    private String name;

    public CreateRoleDTO() {
    }

    public CreateRoleDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

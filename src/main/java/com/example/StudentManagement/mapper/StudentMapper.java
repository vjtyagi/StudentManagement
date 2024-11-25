package com.example.StudentManagement.mapper;

import org.springframework.stereotype.Component;

import com.example.StudentManagement.dto.CreateStudentDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.Student;

@Component
public class StudentMapper {
    public Student toEntity(CreateStudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setDateOfBirth(dto.getDateOfBirth());
        student.setDepartment(dto.getDepartment());
        return student;
    }

    public StudentResponseDTO toDto(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setDateOfBirth(student.getDateOfBirth());
        dto.setDepartment(student.getDepartment());
        return dto;
    }
}

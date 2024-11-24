package com.example.StudentManagement.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.StudentManagement.dto.CreateStudentDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.Student;

public interface StudentService {
    StudentResponseDTO createStudent(CreateStudentDTO studentDTO);

    StudentResponseDTO getStudentById(Long id);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO updateStudent(Long id, CreateStudentDTO studentDTO);

    void deleteStudent(Long id);

    StudentResponseDTO linkStudentToUser(Long studentId, Long userId);

    List<EnrollmentResponseDTO> getStudentEnrollments(Long studentId);

    boolean isOwner(Authentication authentication, Long id);

}

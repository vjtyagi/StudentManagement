package com.example.StudentManagement.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.example.StudentManagement.dto.CreateEnrollmentDTO;
import com.example.StudentManagement.dto.EnrollmentCourseDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;

public interface EnrollmentService {
    EnrollmentResponseDTO createEnrollment(CreateEnrollmentDTO enrollmentDTO);

    EnrollmentResponseDTO getEnrollmentById(Long id);

    EnrollmentResponseDTO updateEnrollment(Long id, CreateEnrollmentDTO enrollmentDTO);

    // List<EnrollmentResponseDTO> getAllEnrollments();

    List<EnrollmentCourseDTO> getAllEnrollmentsWithCourse();

    void deleteEnrollment(Long id);

    boolean isOwner(Long id, Authentication authentication);

    double calculateGPA(Long studentId);

}

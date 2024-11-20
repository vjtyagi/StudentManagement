package com.example.StudentManagement.service;

import com.example.StudentManagement.dto.CreateEnrollmentDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;

public interface EnrollmentService {
    EnrollmentResponseDTO createEnrollment(CreateEnrollmentDTO enrollmentDTO);

    EnrollmentResponseDTO getEnrollmentById(Long id);

    EnrollmentResponseDTO updateEnrollment(Long id, CreateEnrollmentDTO enrollmentDTO);

    void deleteEnrollment(Long id);
}

package com.example.StudentManagement.mapper;

import org.springframework.stereotype.Component;

import com.example.StudentManagement.dto.CreateEnrollmentDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.entity.Enrollment;

@Component
public class EnrollmentMapper {
    public Enrollment toEntity(CreateEnrollmentDTO enrollmentDTO) {
        Enrollment enrollment = new Enrollment();
        enrollment.setSemester(enrollmentDTO.getSemester());
        enrollment.setGrade(enrollmentDTO.getGrade());
        enrollment.setStatus(enrollmentDTO.getStatus());
        return enrollment;
    }

    public EnrollmentResponseDTO toDto(Enrollment enrollment) {
        EnrollmentResponseDTO responseDTO = new EnrollmentResponseDTO();
        responseDTO.setCourseId(enrollment.getCourse().getId());
        responseDTO.setStudentId(enrollment.getStudent().getId());
        responseDTO.setGrade(enrollment.getGrade());
        responseDTO.setSemester(enrollment.getSemester());
        responseDTO.setId(enrollment.getId());
        responseDTO.setStatus(enrollment.getStatus());
        return responseDTO;
    }
}

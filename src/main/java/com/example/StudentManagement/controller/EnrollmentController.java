package com.example.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement.dto.CreateEnrollmentDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(@RequestBody CreateEnrollmentDTO enrollmentDTO) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollmentDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> updateEnrollment(@PathVariable Long id,
            @RequestBody CreateEnrollmentDTO enrollmentDTO) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollmentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

}

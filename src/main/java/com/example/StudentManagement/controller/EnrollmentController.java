package com.example.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enrollments")
@Validated
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PreAuthorize("hasAnyRole('ADMIN', 'STUDENT')")
    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(
            @Valid @RequestBody CreateEnrollmentDTO enrollmentDTO) {
        return ResponseEntity.ok(enrollmentService.createEnrollment(enrollmentDTO));
    }

    @PreAuthorize("hasRole('ADMIN') or @enrollmentService.isOwner(#id, authentication)")
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> getEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @PreAuthorize("hasRole('ADMIN') or @enrollmentService.isOwner(#id, authentication)")
    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> updateEnrollment(@PathVariable Long id,
            @RequestBody CreateEnrollmentDTO enrollmentDTO) {
        return ResponseEntity.ok(enrollmentService.updateEnrollment(id, enrollmentDTO));
    }

    @PreAuthorize("hasRole('ADMIN') or @enrollmentService.isOwner(#id, authentication)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }

}

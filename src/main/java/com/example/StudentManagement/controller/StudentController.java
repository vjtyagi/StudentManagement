package com.example.StudentManagement.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateStudentDTO;
import com.example.StudentManagement.dto.CreateStudentUserDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.service.CourseService;
import com.example.StudentManagement.service.EnrollmentService;
import com.example.StudentManagement.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/students")
@Validated
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private EnrollmentService enrollmentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.createStudent(studentDTO));
    }

    @PreAuthorize("hasRole('ADMIN') or @studentService.isOwner(authentication, #id)")
    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PreAuthorize("hasRole('ADMIN') or @studentService.isOwner(authentication, #id)")
    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id,
            @RequestBody CreateStudentDTO studentDTO) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{studentId}/linkUser/{userId}")
    public ResponseEntity<StudentResponseDTO> linkStudentToUser(@PathVariable Long studentId,
            @PathVariable Long userId) {
        StudentResponseDTO studentResponseDTO = studentService.linkStudentToUser(studentId, userId);
        return ResponseEntity.ok(studentResponseDTO);
    }

    @PreAuthorize("hasRole('ADMIN') or @studentService.isOwner(authentication, #id)")
    @GetMapping("/{id}/enrollments")
    public ResponseEntity<List<EnrollmentResponseDTO>> getStudentEnrollments(@PathVariable Long id) {
        List<EnrollmentResponseDTO> enrollments = studentService.getStudentEnrollments(id);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/{id}/courses")
    public ResponseEntity<List<CourseResponseDTO>> getStudentCourses(@PathVariable Long id) {
        List<CourseResponseDTO> courses = courseService.getCoursesByStudentId(id);
        return ResponseEntity.ok(courses);
    }

    @PreAuthorize("hasRole('ADMIN') or @studentService.isOwner(authentication, #id)")
    @GetMapping("/{id}/gpa")
    public ResponseEntity<Double> calculateGPA(@PathVariable Long id) {
        double gpa = enrollmentService.calculateGPA(id);
        return ResponseEntity.ok(gpa);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/withuser")
    public ResponseEntity<StudentResponseDTO> createStudentWithUser(
            @RequestBody CreateStudentUserDTO createStudentDTO) {
        return ResponseEntity.ok(studentService.createStudentWithUser(createStudentDTO));
    }

}

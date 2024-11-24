package com.example.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateCourseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.service.CourseService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/courses")
@Validated
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@Valid @RequestBody CreateCourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> getCourse(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long Id,
            @RequestBody CreateCourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.updateCourse(Id, courseDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents(@PathVariable Long id) {
        List<StudentResponseDTO> students = courseService.getAllStudents(id);
        return ResponseEntity.ok(students);
    }
}

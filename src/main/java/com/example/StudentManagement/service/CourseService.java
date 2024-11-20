package com.example.StudentManagement.service;

import java.util.List;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateCourseDTO;

public interface CourseService {
    CourseResponseDTO createCourse(CreateCourseDTO courseDTO);

    CourseResponseDTO getCourseById(Long id);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO);

    void deleteCourse(Long id);
}

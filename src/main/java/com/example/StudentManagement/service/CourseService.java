package com.example.StudentManagement.service;

import java.util.List;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateCourseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;

public interface CourseService {
    CourseResponseDTO createCourse(CreateCourseDTO courseDTO);

    CourseResponseDTO getCourseById(Long id);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO);

    void deleteCourse(Long id);

    List<StudentResponseDTO> getAllStudents(Long id);

    List<CourseResponseDTO> getCoursesByStudentId(Long id);
}

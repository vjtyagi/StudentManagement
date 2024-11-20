package com.example.StudentManagement.mapper;

import org.springframework.stereotype.Component;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateCourseDTO;
import com.example.StudentManagement.entity.Course;

@Component
public class CourseMapper {
    public Course toEntity(CreateCourseDTO courseDTO) {
        Course course = new Course();
        course.setCourseCode(courseDTO.getCourseCode());
        course.setCourseName(courseDTO.getCourseName());
        course.setCredits(courseDTO.getCredits());
        course.setDepartment(courseDTO.getDepartment());
        return course;
    }

    public CourseResponseDTO toDto(Course course) {
        CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
        courseResponseDTO.setCourseCode(course.getCourseCode());
        courseResponseDTO.setCourseName(course.getCourseName());
        courseResponseDTO.setCredits(course.getCredits());
        courseResponseDTO.setDepartment(course.getDepartment());
        courseResponseDTO.setId(course.getId());
        return courseResponseDTO;
    }
}

package com.example.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagement.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseCode(String code);
}

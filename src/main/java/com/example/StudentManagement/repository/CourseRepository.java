package com.example.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagement.entity.Course;
import java.util.List;
import com.example.StudentManagement.entity.enums.Department;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseCode(String code);

    List<Course> findByDepartment(Department department);
}

package com.example.StudentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Student;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long id);

    @Query("SELECT e.student FROM Enrollment e WHERE e.course.id = :id")
    List<Student> findStudentsByCourseId(Long id);

    @Query("SELECT e.course FROM Enrollment e WHERE e.student.id = :id")
    List<Course> findCoursesByStudentId(Long id);
}

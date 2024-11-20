package com.example.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagement.entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}

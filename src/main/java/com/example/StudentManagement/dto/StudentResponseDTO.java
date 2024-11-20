package com.example.StudentManagement.dto;

import java.time.LocalDate;

import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.entity.enums.EnrollmentStatus;

public class StudentResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Department Department;
    private EnrollmentStatus enrollmentStatus;
    private LocalDate dateOfBirth;

    public StudentResponseDTO() {
    }

    public StudentResponseDTO(Long id, String firstName, String lastName,
            com.example.StudentManagement.entity.enums.Department department, EnrollmentStatus enrollmentStatus,
            LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Department = department;
        this.enrollmentStatus = enrollmentStatus;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return Department;
    }

    public void setDepartment(Department department) {
        Department = department;
    }

    public EnrollmentStatus getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(EnrollmentStatus enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

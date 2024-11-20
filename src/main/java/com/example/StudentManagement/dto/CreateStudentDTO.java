package com.example.StudentManagement.dto;

import java.time.LocalDate;

import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.entity.enums.EnrollmentStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentDTO {
    @NotBlank(message = "First name is requird")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Username is required")
    private String userName;
    private Department department;
    private EnrollmentStatus enrollmentStatus;
    private LocalDate dateOfBirth;

    public CreateStudentDTO() {
    }

    public CreateStudentDTO(String firstName, String lastName, String userName,
            Department department, EnrollmentStatus enrollmentStatus,
            LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.department = department;
        this.enrollmentStatus = enrollmentStatus;
        this.dateOfBirth = dateOfBirth;
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
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

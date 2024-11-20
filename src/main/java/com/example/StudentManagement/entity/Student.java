package com.example.StudentManagement.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.entity.enums.EnrollmentStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Department Department;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EnrollmentStatus enrollmentStatus;

    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(Long id, User user, String firstName, String lastName,
            com.example.StudentManagement.entity.enums.@NotNull Department department,
            @NotNull EnrollmentStatus enrollmentStatus, LocalDate dateOfBirth) {
        this.id = id;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

}
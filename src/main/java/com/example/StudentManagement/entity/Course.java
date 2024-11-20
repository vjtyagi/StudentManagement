package com.example.StudentManagement.entity;

import java.util.HashSet;
import java.util.Set;

import com.example.StudentManagement.entity.enums.Department;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course code is required")
    @Column(nullable = false, unique = true)
    private String courseCode;

    @NotBlank(message = "Course name is required")
    @Column(nullable = false)
    private String courseName;

    @NotNull(message = "Credits are required")
    @Column(nullable = false)
    private Integer credits;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Department is required")
    @Column(nullable = false)
    private Department department;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Enrollment> enrollments = new HashSet<>();

    public Course() {
    }

    public Course(Long id, @NotBlank(message = "Course code is required") String courseCode,
            @NotBlank(message = "Course name is required") String courseName,
            @NotNull(message = "Credits are required") Integer credits,
            @NotNull(message = "Department is required") Department department) {
        this.id = id;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

}

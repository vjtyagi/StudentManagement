package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.enums.Department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateCourseDTO {

    @NotBlank(message = "Course code is required")
    private String courseCode;

    @NotBlank(message = "Course name is required")
    private String courseName;

    @NotNull(message = "Credits are required")
    private Integer credits;

    @NotNull(message = "Department is required")
    private Department department;

    public CreateCourseDTO() {
    }

    public CreateCourseDTO(@NotBlank(message = "Course code is required") String courseCode,
            @NotBlank(message = "Course name is required") String courseName,
            @NotNull(message = "Credits are required") Integer credits,
            @NotNull(message = "Department is required") Department department) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
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

}

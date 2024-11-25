package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.enums.EnrollmentStatus;
import com.example.StudentManagement.entity.enums.Grade;

import jakarta.validation.constraints.NotNull;

public class CreateEnrollmentDTO {

    @NotNull(message = "Student ID is required")
    private Long studentId;
    @NotNull(message = "Course ID is required")
    private Long courseId;
    private String semester;
    private Grade grade;
    private EnrollmentStatus status;

    public CreateEnrollmentDTO() {
    }

    public CreateEnrollmentDTO(@NotNull(message = "Student ID is required") Long studentId,
            @NotNull(message = "Course ID is required") Long courseId, String semester, Grade grade,
            EnrollmentStatus status) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
        this.status = status;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

}

package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Student;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class CreateEnrollmentDTO {

    @NotNull(message = "Student ID is required")
    private Long studentId;
    @NotNull(message = "Course ID is required")
    private Long courseId;
    private String semester;
    private String grade;

    public CreateEnrollmentDTO() {
    }

    public CreateEnrollmentDTO(@NotNull(message = "Student ID is required") Long studentId,
            @NotNull(message = "Course ID is required") Long courseId, String semester, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}

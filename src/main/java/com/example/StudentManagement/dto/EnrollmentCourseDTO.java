package com.example.StudentManagement.dto;

import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.entity.enums.EnrollmentStatus;
import com.example.StudentManagement.entity.enums.Grade;

public class EnrollmentCourseDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String courseName;
    private Department department;
    private String semester;
    private Grade grade;
    private EnrollmentStatus status;

    public EnrollmentCourseDTO() {
    }

    public EnrollmentCourseDTO(Long id, Long studentId, Long courseId, String courseName, Department department,
            String semester, Grade grade, EnrollmentStatus status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.semester = semester;
        this.grade = grade;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

package com.example.StudentManagement.dto;

public class EnrollmentResponseDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private String semester;
    private String grade;

    public EnrollmentResponseDTO() {
    }

    public EnrollmentResponseDTO(Long id, Long studentId, Long courseId, String semester, String grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.semester = semester;
        this.grade = grade;
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

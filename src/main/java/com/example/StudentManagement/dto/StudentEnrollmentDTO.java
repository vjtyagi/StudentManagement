package com.example.StudentManagement.dto;

public class StudentEnrollmentDTO {
    private Long studentId;
    private String studentName;
    private Long totalEnrollments;
    private Double averageGrade;

    public StudentEnrollmentDTO(Long studentId, String studentName, Long totalEnrollments, Double averageGrade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.totalEnrollments = totalEnrollments;
        this.averageGrade = averageGrade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getTotalEnrollments() {
        return totalEnrollments;
    }

    public void setTotalEnrollments(Long totalEnrollments) {
        this.totalEnrollments = totalEnrollments;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

}

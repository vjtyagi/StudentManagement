package com.example.StudentManagement.dto;

public class CoursePerformanceDTO {
    private String courseName;
    private double averageGrade;

    public CoursePerformanceDTO() {
    }

    public CoursePerformanceDTO(String courseName, double averageGrade) {
        this.courseName = courseName;
        this.averageGrade = averageGrade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

}

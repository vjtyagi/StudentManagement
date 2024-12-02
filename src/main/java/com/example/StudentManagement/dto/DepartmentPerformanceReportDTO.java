package com.example.StudentManagement.dto;

import java.util.List;

import com.example.StudentManagement.entity.enums.Department;

public class DepartmentPerformanceReportDTO {

    private Department department;
    private List<CoursePerformanceDTO> courses;

    public DepartmentPerformanceReportDTO() {
    }

    public DepartmentPerformanceReportDTO(Department department, List<CoursePerformanceDTO> courses) {
        this.department = department;
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<CoursePerformanceDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursePerformanceDTO> courses) {
        this.courses = courses;
    }

}

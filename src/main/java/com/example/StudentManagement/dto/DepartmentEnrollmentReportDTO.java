package com.example.StudentManagement.dto;

import java.util.List;

import com.example.StudentManagement.entity.enums.Department;

public class DepartmentEnrollmentReportDTO {
    private Department department;
    private List<SemesterDTO> semesters;

    public DepartmentEnrollmentReportDTO(Department department, List<SemesterDTO> semesters) {
        this.department = department;
        this.semesters = semesters;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<SemesterDTO> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<SemesterDTO> semesters) {
        this.semesters = semesters;
    }

}

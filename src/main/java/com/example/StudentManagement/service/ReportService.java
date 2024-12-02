package com.example.StudentManagement.service;

import java.util.List;

import com.example.StudentManagement.dto.DepartmentDTO;
import com.example.StudentManagement.dto.DepartmentEnrollmentReportDTO;
import com.example.StudentManagement.dto.DepartmentPerformanceReportDTO;
import com.example.StudentManagement.entity.enums.Department;

public interface ReportService {
    DepartmentPerformanceReportDTO getDepartmentPerformanceReport(Department department);

    List<DepartmentEnrollmentReportDTO> getDepartmentEnrollmentReport();

}
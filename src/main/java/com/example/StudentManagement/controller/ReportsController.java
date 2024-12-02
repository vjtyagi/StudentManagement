package com.example.StudentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentManagement.dto.DepartmentEnrollmentReportDTO;
import com.example.StudentManagement.dto.DepartmentPerformanceReportDTO;
import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.service.EnrollmentService;
import com.example.StudentManagement.service.ReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportsController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/departments/{department}")
    public ResponseEntity<DepartmentPerformanceReportDTO> getDepartmentPerformanceReport(
            @PathVariable Department department) {
        DepartmentPerformanceReportDTO report = reportService.getDepartmentPerformanceReport(department);
        return ResponseEntity.ok(report);
    }

    @GetMapping("/enrollment-report")
    public ResponseEntity<List<DepartmentEnrollmentReportDTO>> getEnrollmentReport() {
        return ResponseEntity.ok(reportService.getDepartmentEnrollmentReport());
    }
}

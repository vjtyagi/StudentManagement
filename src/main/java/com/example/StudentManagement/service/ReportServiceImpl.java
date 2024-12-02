package com.example.StudentManagement.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StudentManagement.dto.CoursePerformanceDTO;
import com.example.StudentManagement.dto.DepartmentDTO;
import com.example.StudentManagement.dto.DepartmentEnrollmentReportDTO;
import com.example.StudentManagement.dto.DepartmentPerformanceReportDTO;
import com.example.StudentManagement.dto.SemesterDTO;
import com.example.StudentManagement.dto.StudentEnrollmentDTO;
import com.example.StudentManagement.entity.enums.Department;
import com.example.StudentManagement.repository.EnrollmentRepository;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public DepartmentPerformanceReportDTO getDepartmentPerformanceReport(Department department) {
        List<CoursePerformanceDTO> coursePerformances = enrollmentRepository
                .findAvgGradeByCourseForDepartment(department);
        DepartmentPerformanceReportDTO report = new DepartmentPerformanceReportDTO();
        report.setCourses(coursePerformances);
        report.setDepartment(department);
        return report;
    }

    @Override
    public List<DepartmentEnrollmentReportDTO> getDepartmentEnrollmentReport() {
        List<Object[]> results = enrollmentRepository.findGroupedEnrollmentData();
        Map<Department, Map<String, List<Object[]>>> groupedData = results.stream()
                .collect(Collectors.groupingBy(
                        result -> (Department) result[0], // department
                        Collectors.groupingBy(
                                result -> (String) result[1] // semester
                        )));
        // converting to nested dto structure
        return groupedData.entrySet().stream()
                .map(departmentEntry -> {
                    Department department = (Department) departmentEntry.getKey();
                    List<SemesterDTO> semesterDTOs = departmentEntry.getValue().entrySet().stream()
                            .map(semesterEntry -> {
                                String semester = semesterEntry.getKey();
                                List<StudentEnrollmentDTO> studentDTOs = semesterEntry.getValue().stream()
                                        .map(result -> {
                                            Long studentId = (Long) result[2];
                                            String studentName = (String) result[3];
                                            Long totalEnrollments = (Long) result[4];
                                            Double averageGrade = (Double) result[5];
                                            return new StudentEnrollmentDTO(studentId, studentName, totalEnrollments,
                                                    averageGrade);
                                        })
                                        .collect(Collectors.toList());
                                return new SemesterDTO(semester, studentDTOs);
                            })
                            .collect(Collectors.toList());
                    return new DepartmentEnrollmentReportDTO(department, semesterDTOs);
                })
                .collect(Collectors.toList());

    }

}

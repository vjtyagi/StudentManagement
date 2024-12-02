package com.example.StudentManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.StudentManagement.dto.CoursePerformanceDTO;
import com.example.StudentManagement.dto.DepartmentEnrollmentReportDTO;
import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.enums.Department;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentId(Long id);

    @Query("SELECT e.student FROM Enrollment e WHERE e.course.id = :id")
    List<Student> findStudentsByCourseId(Long id);

    @Query("SELECT e.course FROM Enrollment e WHERE e.student.id = :id")
    List<Course> findCoursesByStudentId(Long id);

    @Query("SELECT e FROM Enrollment e  JOIN FETCH e.course WHERE e.student.id = :studentId AND e.grade IS NOT NULL AND e.status = 'GRADUATED' ")
    List<Enrollment> findCompletedEnrollmentsByStudentId(@Param("studentId") Long studentId);

    @Query(value = """
            SELECT new com.example.StudentManagement.dto.CoursePerformanceDTO(
                c.courseName,
                SUM(CASE
                    WHEN e.grade = 'A' THEN 4.0 * c.credits
                    WHEN e.grade = 'B' THEN 3.0 * c.credits
                    WHEN e.grade = 'C' THEN 2.0 * c.credits
                    WHEN e.grade = 'D' THEN 1.0 * c.credits
                    WHEN e.grade = 'F' THEN 0.0 * c.credits
                END)/SUM(c.credits)
            )
                FROM Enrollment e
                JOIN e.course c
                WHERE c.department = :department AND e.status = 'GRADUATED'
                GROUP BY c.id, c.courseName
            """)
    List<CoursePerformanceDTO> findAvgGradeByCourseForDepartment(@Param("department") Department department);

    @Query("SELECT e FROM Enrollment e JOIN FETCH e.course c")
    List<Enrollment> findAllEnrollmentsWithCourse();

    @Query("""
            SELECT
                c.department as department,
                e.semester as semester,
                e.student.id as studentId,
                CONCAT(e.student.firstName, ' ', e.student.lastName) as studentName,
                Count(e) as totalEnrollments,
                SUM(CASE
                    WHEN e.grade = 'A' THEN 4.0 * c.credits
                    WHEN e.grade = 'B' THEN 3.0 * c.credits
                    WHEN e.grade = 'C' THEN 2.0 * c.credits
                    WHEN e.grade = 'D' THEN 1.0 * c.credits
                    WHEN e.grade = 'F' THEN 0.0 * c.credits
                    ELSE 0.0

                END ) / SUM(c.credits) as averageGrade
                FROM Enrollment e
                JOIN e.course c
                JOIN e.student s
                WHERE e.status = 'GRADUATED'
                GROUP BY c.department, e.semester, e.student.id
                """)
    List<Object[]> findGroupedEnrollmentData();

}

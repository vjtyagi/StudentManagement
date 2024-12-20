package com.example.StudentManagement.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CreateEnrollmentDTO;
import com.example.StudentManagement.dto.EnrollmentCourseDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.UserPrincipal;
import com.example.StudentManagement.entity.enums.Grade;
import com.example.StudentManagement.mapper.EnrollmentMapper;
import com.example.StudentManagement.repository.CourseRepository;
import com.example.StudentManagement.repository.EnrollmentRepository;
import com.example.StudentManagement.repository.StudentRepository;

@Service("enrollmentService")
@Transactional
public class EnrollmentServiceImpl implements EnrollmentService {
        private static final Logger logger = LoggerFactory.getLogger(EnrollmentServiceImpl.class);
        @Autowired
        private EnrollmentRepository enrollmentRepository;
        @Autowired
        private EnrollmentMapper enrollmentMapper;
        @Autowired
        private CourseRepository courseRepository;
        @Autowired
        private StudentRepository studentRepository;

        @Override
        public EnrollmentResponseDTO createEnrollment(CreateEnrollmentDTO enrollmentDTO) {
                Course course = courseRepository.findById(enrollmentDTO.getCourseId())
                                .orElseThrow(() -> new RuntimeException("Course Id not found"));
                Student student = studentRepository.findById(enrollmentDTO.getStudentId())
                                .orElseThrow(() -> new RuntimeException("Student Id not found"));
                Enrollment newEnrollment = enrollmentMapper.toEntity(enrollmentDTO);
                newEnrollment.setCourse(course);
                newEnrollment.setStudent(student);
                Enrollment enrollment = enrollmentRepository.save(newEnrollment);
                return enrollmentMapper.toDto(enrollment);

        }

        @Override
        public EnrollmentResponseDTO getEnrollmentById(Long id) {
                Enrollment enrollment = enrollmentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Enrollment Id not found"));
                return enrollmentMapper.toDto(enrollment);
        }

        @Override
        public EnrollmentResponseDTO updateEnrollment(Long id, CreateEnrollmentDTO enrollmentDTO) {
                Enrollment exisitngEnrollment = enrollmentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Enrollment Id not found"));
                Course course = courseRepository.findById(enrollmentDTO.getCourseId())
                                .orElseThrow(() -> new RuntimeException("Course Id not found"));
                Student student = studentRepository.findById(enrollmentDTO.getStudentId())
                                .orElseThrow(() -> new RuntimeException("Student Id not found"));
                exisitngEnrollment.setCourse(course);
                exisitngEnrollment.setStudent(student);
                exisitngEnrollment.setGrade(enrollmentDTO.getGrade());
                exisitngEnrollment.setSemester(enrollmentDTO.getSemester());
                exisitngEnrollment.setStatus(enrollmentDTO.getStatus());
                Enrollment updatedEnrollment = enrollmentRepository.save(exisitngEnrollment);
                return enrollmentMapper.toDto(updatedEnrollment);
        }

        @Override
        public void deleteEnrollment(Long id) {
                enrollmentRepository.deleteById(id);
        }

        @Override
        public boolean isOwner(Long id, Authentication authentication) {
                UserPrincipal currentUser = (UserPrincipal) authentication.getPrincipal();
                Student student = studentRepository.findByUserId(currentUser.getId())
                                .orElseThrow(() -> new RuntimeException("Student not found"));
                Enrollment enrollment = enrollmentRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
                return enrollment.getStudent().getId().equals(student.getId());
        }

        @Override
        public double calculateGPA(Long studentId) {
                List<Enrollment> enrollments = enrollmentRepository.findCompletedEnrollmentsByStudentId(studentId);
                double totalGradePoints = 0.0;
                int totalCredits = 0;
                for (Enrollment enrollment : enrollments) {
                        Grade grade = enrollment.getGrade();
                        double gradePoint = grade.getGradePoint();
                        int credits = enrollment.getCourse().getCredits();
                        totalGradePoints += (gradePoint * credits);
                        totalCredits += credits;
                }
                logger.debug("totalGradePoints: {}, totalCredits: {}", totalGradePoints, totalCredits);
                double gpa = totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
                BigDecimal roundedGpa = BigDecimal.valueOf(gpa).setScale(2, RoundingMode.HALF_UP);
                return roundedGpa.doubleValue();
        }

        @Override
        public List<EnrollmentCourseDTO> getAllEnrollmentsWithCourse() {
                List<Enrollment> enrollments = enrollmentRepository.findAll();
                List<EnrollmentCourseDTO> enrollmentList = new ArrayList<>();
                for (Enrollment enrollment : enrollments) {
                        enrollmentList.add(enrollmentMapper.toCourseDTO(enrollment));
                }
                return enrollmentList;
        }

}

package com.example.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CreateStudentDTO;
import com.example.StudentManagement.dto.CreateStudentUserDTO;
import com.example.StudentManagement.dto.CreateUserDTO;
import com.example.StudentManagement.dto.EnrollmentResponseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.Enrollment;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.entity.UserPrincipal;
import com.example.StudentManagement.mapper.EnrollmentMapper;
import com.example.StudentManagement.mapper.StudentMapper;
import com.example.StudentManagement.repository.EnrollmentRepository;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.repository.UserRepository;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private EnrollmentMapper enrollmentMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public StudentResponseDTO createStudent(CreateStudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> studentsList = new ArrayList<>();
        for (Student student : students) {
            studentsList.add(studentMapper.toDto(student));
        }
        return studentsList;
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, CreateStudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFirstName(studentDTO.getFirstName());
        existingStudent.setLastName(studentDTO.getLastName());
        existingStudent.setDateOfBirth(studentDTO.getDateOfBirth());
        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toDto(updatedStudent);

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDTO linkStudentToUser(Long studentId, Long userId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        student.setUser(user);
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDto(updatedStudent);
    }

    @Override
    public List<EnrollmentResponseDTO> getStudentEnrollments(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        List<EnrollmentResponseDTO> enrollmentList = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            enrollmentList.add(enrollmentMapper.toDto(enrollment));
        }
        return enrollmentList;
    }

    @Override
    public boolean isOwner(Authentication authentication, Long id) {
        UserPrincipal user = (UserPrincipal) authentication.getPrincipal();
        Student student = studentRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        boolean result = student.getId().equals(id);
        return result;
    }

    @Override
    public StudentResponseDTO createStudentWithUser(CreateStudentUserDTO studentDTO) {
        // Step1: Create a user
        User user = new User();
        user.setUsername(studentDTO.getUsername());
        user.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
        user.setEmail(studentDTO.getEmail());

        User savedUser = userRepository.save(user);

        // Step 2: Create a student by settting user reference
        Student student = studentMapper.toEntity(studentDTO);
        student.setUser(savedUser);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

}

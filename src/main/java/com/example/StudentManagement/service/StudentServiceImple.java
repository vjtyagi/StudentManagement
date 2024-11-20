package com.example.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CreateStudentDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.entity.User;
import com.example.StudentManagement.mapper.StudentMapper;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.repository.UserRepository;

@Service
@Transactional
public class StudentServiceImple implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public StudentResponseDTO createStudent(CreateStudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        User savedUser = userRepository.findByUsername(studentDTO.getUserName())
                .orElseThrow(() -> new RuntimeException("User Not Found"));
        student.setUser(savedUser);
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
        existingStudent.setDepartment(studentDTO.getDepartment());
        existingStudent.setEnrollmentStatus(studentDTO.getEnrollmentStatus());
        Student updatedStudent = studentRepository.save(existingStudent);
        return studentMapper.toDto(updatedStudent);

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentResponseDTO linkStudentToUser(Long studentId, Long userId) {
        Student student = studentRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Student Not Found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        student.setUser(user);
        Student updatedStudent = studentRepository.save(student);
        return studentMapper.toDto(updatedStudent);
    }

}

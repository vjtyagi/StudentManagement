package com.example.StudentManagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.StudentManagement.dto.CourseResponseDTO;
import com.example.StudentManagement.dto.CreateCourseDTO;
import com.example.StudentManagement.dto.StudentResponseDTO;
import com.example.StudentManagement.entity.Course;
import com.example.StudentManagement.entity.Student;
import com.example.StudentManagement.mapper.CourseMapper;
import com.example.StudentManagement.mapper.StudentMapper;
import com.example.StudentManagement.repository.CourseRepository;
import com.example.StudentManagement.repository.EnrollmentRepository;

@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public CourseResponseDTO createCourse(CreateCourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        Course newCourse = courseRepository.save(course);
        return courseMapper.toDto(newCourse);
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course Id Not found"));
        return courseMapper.toDto(course);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseResponseDTO> coursesList = new ArrayList<>();
        for (Course course : courses) {
            coursesList.add(courseMapper.toDto(course));
        }
        return coursesList;
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CreateCourseDTO courseDTO) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Id not found"));
        existingCourse.setCourseCode(courseDTO.getCourseCode());
        existingCourse.setCourseName(courseDTO.getCourseName());
        existingCourse.setCredits(courseDTO.getCredits());
        existingCourse.setDepartment(courseDTO.getDepartment());
        Course updatedCourse = courseRepository.save(existingCourse);
        return courseMapper.toDto(updatedCourse);

    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<StudentResponseDTO> getAllStudents(Long id) {
        List<Student> students = enrollmentRepository.findStudentsByCourseId(id);
        List<StudentResponseDTO> studentsList = new ArrayList<>();
        for (Student student : students) {
            studentsList.add(studentMapper.toDto(student));
        }
        return studentsList;
    }

    @Override
    public List<CourseResponseDTO> getCoursesByStudentId(Long id) {
        List<Course> courses = enrollmentRepository.findCoursesByStudentId(id);
        List<CourseResponseDTO> courseList = new ArrayList<>();
        for (Course course : courses) {
            courseList.add(courseMapper.toDto(course));
        }
        return courseList;
    }

}

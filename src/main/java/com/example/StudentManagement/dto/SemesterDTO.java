package com.example.StudentManagement.dto;

import java.util.List;

public class SemesterDTO {
    private String semester;
    private List<StudentEnrollmentDTO> students;

    public SemesterDTO(String semester, List<StudentEnrollmentDTO> students) {
        this.semester = semester;
        this.students = students;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public List<StudentEnrollmentDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEnrollmentDTO> students) {
        this.students = students;
    }

}

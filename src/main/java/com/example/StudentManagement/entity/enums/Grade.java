package com.example.StudentManagement.entity.enums;

public enum Grade {
    A(4.0),
    B(3.0),
    C(2.0),
    D(1.0),
    F(0.0);

    private final double gradePoint;

    Grade(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public static Grade fromString(String grade) {
        try {
            return Grade.valueOf(grade.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid grade " + grade);
        }
    }
}

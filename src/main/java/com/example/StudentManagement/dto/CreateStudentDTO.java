package com.example.StudentManagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentDTO {
    @NotBlank(message = "First name is requird")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;

    private LocalDate dateOfBirth;

    public CreateStudentDTO() {
    }

    public CreateStudentDTO(String firstName, String lastName,
            LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;

        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

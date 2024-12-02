package com.example.StudentManagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;

public class CreateStudentUserDTO {
    // User Attributes
    @NotBlank(message = "Username is required")
    private String username;
    private String password;
    private String email;

    // Student Attributes
    @NotBlank(message = "First name is requird")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private LocalDate dateOfBirth;

    public CreateStudentUserDTO() {
    }

    public CreateStudentUserDTO(@NotBlank(message = "Username is required") String username, String password,
            String email, @NotBlank(message = "First name is requird") String firstName,
            @NotBlank(message = "Last name is required") String lastName, LocalDate dateOfBirth) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

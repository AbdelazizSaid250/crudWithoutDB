package com.example.crud.model.dto;

import jakarta.validation.constraints.*;
import lombok.Value;

@Value
public class StudentDto {
    @NotBlank(message = "Name is required and cannot be empty!!")
    @Size(min = 2, max = 30, message = "Name length must be between 2 and 30 characters")
    String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 30, message = "Age must not be greater that 60")
    int age;

    @NotBlank(message = "Email is required and cannot be empty!!")
    @Email(message = "Email is not valid")
    String email;

    @NotNull(message = "Degree is required")
    @Min(value = 0, message = "Degree must be greater than")
    @Max(value = 100, message = "Degree must not exceed 100")
    Float degree;

    @NotBlank(message = "Phone is required and cannot be empty!!")
    @Pattern(regexp = "^\\+201[0-2,5]\\d{8}$", message = "Mobile number must be valid")
    String phone;

    @NotBlank(message = "Enrollment Date is required and cannot be empty!!")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Enrollment Date must be formatted with the right format")
    String enrollmentDate;

    AddressDto addressDto;
}

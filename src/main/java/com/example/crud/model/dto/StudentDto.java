package com.example.crud.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private String name;
    private int age;
    private String email;
    private Address address;
}

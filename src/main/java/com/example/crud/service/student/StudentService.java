package com.example.crud.service.student;

import com.example.crud.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);

    StudentDto findById(String id);

    StudentDto findByEmail(String email);

    StudentDto findByEmailAndName(String email, String name);

    List<StudentDto> findAll();

    List<StudentDto> findAllStudentsWithCustomCriteria();

    void update(String id, StudentDto studentDto);

    void remove(String id);
}

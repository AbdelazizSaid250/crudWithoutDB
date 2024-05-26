package com.example.crud.service.student;

import com.example.crud.model.dto.StudentDto;

import java.util.List;

public interface StudentService {

    void save(StudentDto studentDto);

    StudentDto findById(String id);

    List<StudentDto> findAll();

    void update(String id, StudentDto studentDto);

    void remove(String id);
}

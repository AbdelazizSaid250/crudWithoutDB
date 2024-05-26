package com.example.crud.repository.dao.student;

import com.example.crud.model.dto.StudentDto;

import java.util.List;

public interface StudentDao {

    void save(StudentDto studentDto);

    StudentDto findById(String id);

    List<StudentDto> findAll();

    void update(String id, StudentDto studentDto);

    void remove(String id);
}

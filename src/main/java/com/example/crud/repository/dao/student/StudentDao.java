package com.example.crud.dao.student;

import com.example.crud.model.dto.StudentDto;

public interface StudentRepository {

    void save(StudentDto studentDto);
}

package com.example.crud.repository.dao.student;

import com.example.crud.model.entity.Student;

import java.util.List;

public interface StudentCustomRepository {

    List<Student> findAllStudentsWithCustomCriteria();
}

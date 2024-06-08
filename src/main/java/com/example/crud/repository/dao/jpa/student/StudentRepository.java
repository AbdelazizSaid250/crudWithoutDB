package com.example.crud.repository.dao.jpa.student;

import com.example.crud.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findByEmailAndName(String email, String name);

    Optional<List<Student>> findAllByOrderByIdAsc();

    Optional<List<Student>> findAllByAgeGreaterThan(int age);
}

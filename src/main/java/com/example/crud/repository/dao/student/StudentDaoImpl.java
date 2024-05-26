package com.example.crud.repository.dao.student;

import com.example.crud.error.exception.StudentNotFoundException;
import com.example.crud.model.dto.StudentDto;
import com.example.crud.repository.StudentMapRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
public class StudentDaoImpl implements StudentDao {

    Map<String, StudentDto> transientDB;

    public StudentDaoImpl() {
        log.info("StudentDaoImpl");
        transientDB = StudentMapRepository.getInstance();
    }

    @Override
    public void save(StudentDto studentDto) {
        String id = UUID.randomUUID().toString();

        transientDB.put(id, studentDto);
        log.info("Student with name: {} saved with uuid: {}", studentDto.getName(), id);
    }

    @Override
    public StudentDto findById(String id) {
        if (transientDB.containsKey(id)) {
            return transientDB.get(id);
        } else {
            log.error("Student with id: {} not found in the transient DB", id);
            throw new StudentNotFoundException("Student with id: " + id + " not found");
        }
    }

    @Override
    public List<StudentDto> findAll() {
        return transientDB.values().stream().toList();
    }

    @Override
    public void update(String id, StudentDto studentDto) {
        transientDB.put(id, studentDto);
        log.info("Student with id: {} updated with uuid: {}", id, studentDto.getName());
    }

    @Override
    public void remove(String id) {
        transientDB.remove(id);
        log.info("Student with id: {} has been removed", id);
    }
}

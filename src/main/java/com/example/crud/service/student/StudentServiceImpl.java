package com.example.crud.service.student;

import com.example.crud.repository.dao.student.StudentDao;
import com.example.crud.error.exception.StudentAgeException;
import com.example.crud.model.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final String CLASS_NAME = StudentServiceImpl.class.getSimpleName();

    private final StudentDao studentDao;

    @Autowired
    public StudentServiceImpl(StudentDao studentDao) {
        log.info(CLASS_NAME);
        this.studentDao = studentDao;
    }

    @Override
    public void save(StudentDto studentDto) {
        String methodName = "save()";
        if (studentDto.getAge() < 18) {
            log.error("{}, Student Name with: {} is not older that 18 years", methodName, studentDto.getName());
            throw new StudentAgeException("Student is still young!!");
        } else {
            studentDao.save(studentDto);
        }
    }

    @Override
    public StudentDto findById(String id) {
        return studentDao.findById(id);
    }

    @Override
    public List<StudentDto> findAll() {
        return studentDao.findAll();
    }

    @Override
    public void update(String id, StudentDto studentDto) {
        studentDao.update(id, studentDto);
    }

    @Override
    public void remove(String id) {
        studentDao.remove(id);
    }
}

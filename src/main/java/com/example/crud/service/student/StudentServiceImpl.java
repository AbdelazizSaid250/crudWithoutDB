package com.example.crud.service.student;

import com.example.crud.error.exception.DateTimeValidationException;
import com.example.crud.error.exception.StudentNotFoundException;
import com.example.crud.model.entity.Student;
import com.example.crud.repository.dao.jpa.student.StudentRepository;
import com.example.crud.repository.dao.student.StudentDao;
import com.example.crud.error.exception.StudentAgeException;
import com.example.crud.model.dto.StudentDto;
import com.example.crud.util.timing.DateTimeValidator;
import com.example.crud.util.transformation.StudentTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final String CLASS_NAME = StudentServiceImpl.class.getSimpleName();

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        log.info(CLASS_NAME);
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDto studentDto) throws StudentAgeException, DateTimeValidationException {
        String methodName = "save()";
        if (studentDto.getAge() < 18) {
            log.error("{}, Student Name with: {} is not older that 18 years", methodName, studentDto.getName());
            throw new StudentAgeException("Student is still young!!");
        } else {
            Student student = StudentTransformation.toStudent(studentDto);

            studentRepository.save(student);
        }
    }

    @Override
    public StudentDto findById(String id) {
        return studentRepository.findById(id).map(StudentTransformation::toStudentDto)
                .orElseThrow(() -> new StudentNotFoundException("Student not Found with id:" + id));
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentTransformation::toStudentDto).toList();
    }

    @Override
    public void update(String id, StudentDto studentDto) {

        studentRepository.findById(id).map(student -> {
            student.setName(studentDto.getName());
            student.setAge(studentDto.getAge());
            student.setEmail(studentDto.getEmail());
            student.setDegree(studentDto.getDegree());
            student.setPhone(studentDto.getPhone());
            student.setEnrollmentDate(DateTimeValidator.parseDate(studentDto.getEnrollmentDate()));

            studentRepository.save(student);
            return student;
        }).orElseThrow(() -> new StudentNotFoundException("Student not Found with id:" + id));
    }

    @Override
    public void remove(String id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
    }
}

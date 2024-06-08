package com.example.crud.service.student;

import com.example.crud.error.exception.StudentNotFoundException;
import com.example.crud.model.entity.Student;
import com.example.crud.repository.dao.jpa.student.StudentRepository;
import com.example.crud.model.dto.StudentDto;
import com.example.crud.repository.dao.student.StudentCustomRepository;
import com.example.crud.util.timing.DateTimeValidator;
import com.example.crud.util.transformation.StudentTransformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.crud.error.util.ErrorDescription.STUDENT_NOT_FOUND;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {


    private static final String CLASS_NAME = StudentServiceImpl.class.getSimpleName();

    private final StudentRepository studentRepository;
    private final StudentCustomRepository studentCustomRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentCustomRepository studentCustomRepository) {
        log.info(CLASS_NAME);
        this.studentCustomRepository = studentCustomRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void save(StudentDto studentDto) {
        Student student = StudentTransformation.toStudent(studentDto);

        studentRepository.save(student);
    }

    @Override
    public StudentDto findById(String id) {
        return studentRepository.findById(id).map(StudentTransformation::toStudentDto)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + id));
    }

    @Override
    public StudentDto findByEmail(String email) {
        return studentRepository.findByEmail(email)
                .map(StudentTransformation::toStudentDto)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + email));
    }

    @Override
    public StudentDto findByEmailAndName(String email, String name) {
        return studentRepository.findByEmailAndName(email, name)
                .map(StudentTransformation::toStudentDto)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + email));
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentTransformation::toStudentDto).toList();
    }

    @Override
    public List<StudentDto> findAllStudentsWithCustomCriteria() {
        List<Student> foundStudents = studentCustomRepository.findAllStudentsWithCustomCriteria();
        return Optional.ofNullable(foundStudents)
                .map(students -> students.stream().map(StudentTransformation::toStudentDto).toList())
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND));
    }

    @Override
    public void update(String id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + id));

        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setDegree(studentDto.getDegree());
        student.setPhone(studentDto.getPhone());
        student.setEnrollmentDate(DateTimeValidator.parseDate(studentDto.getEnrollmentDate()));

        studentRepository.save(student);
    }

    @Override
    public void remove(String id) {
        Student foundStudent = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND + id));
        studentRepository.delete(foundStudent);
    }
}

package com.example.crud.util.transformation;

import com.example.crud.error.exception.DateTimeValidationException;
import com.example.crud.model.dto.StudentDto;
import com.example.crud.model.entity.Student;
import com.example.crud.util.timing.DateTimeValidator;

import java.util.UUID;

public class StudentTransformation {

    private StudentTransformation() {
    }

    public static Student toStudent(StudentDto studentDto) throws DateTimeValidationException {
        Student student = new Student();
        student.setId(UUID.randomUUID().toString());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setDegree(studentDto.getDegree());
        student.setPhone(studentDto.getPhone());
        student.setEnrollmentDate(DateTimeValidator.parseDate(studentDto.getEnrollmentDate()));

        return student;
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getName(), student.getAge(), student.getEmail(), student.getDegree(),
                student.getPhone(), student.getEnrollmentDate().toString(), null);
    }
}

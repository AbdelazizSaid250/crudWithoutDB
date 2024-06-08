package com.example.crud.util.transformation;

import com.example.crud.error.exception.DateTimeValidationException;
import com.example.crud.model.dto.AddressDto;
import com.example.crud.model.dto.StudentDto;
import com.example.crud.model.entity.Address;
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
        student.setAddress(toAddress(studentDto.getAddressDto()));

        return student;
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student.getName(), student.getAge(), student.getEmail(), student.getDegree(),
                student.getPhone(), student.getEnrollmentDate().toString(), toAddressDto(student.getAddress()));
    }

    public static Address toAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());

        return address;
    }

    public static AddressDto toAddressDto(Address address) {
        return new AddressDto(address.getCountry(), address.getCity(), address.getStreet());
    }
}

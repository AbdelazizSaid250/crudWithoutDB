package com.example.crud.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "degree", nullable = false)
    private Float degree;

    @Column(name = "phone")
    private String phone;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(email, student.email) && Objects.equals(degree, student.degree) && Objects.equals(phone, student.phone) && Objects.equals(enrollmentDate, student.enrollmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email, degree, phone, enrollmentDate);
    }
}

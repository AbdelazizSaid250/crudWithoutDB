package com.example.crud.repository.dao.student;

import com.example.crud.model.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class StudentCustomRepositoryImpl implements StudentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAllStudentsWithCustomCriteria() {
        String query = "SELECT s FROM Student s WHERE s.age > :age AND s.enrollmentDate >= :enrollmentDate AND s.name LIKE :namePattern";
        TypedQuery<Student> typedQuery = entityManager.createQuery(query, Student.class);
        typedQuery.setParameter("age", 18);
        typedQuery.setParameter("enrollmentDate", LocalDate.now().minusYears(1));
        typedQuery.setParameter("namePattern", "R%");

        return typedQuery.getResultList();
    }
}

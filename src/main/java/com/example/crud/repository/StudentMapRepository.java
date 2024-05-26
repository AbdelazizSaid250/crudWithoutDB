package com.example.test.repositories;

import com.example.test.model.dto.StudentDto;

import java.util.HashMap;
import java.util.Map;

public class StudentMapRepository {

    // Shared Resource
    // Lazy Instantiation
    private static Map<Integer, StudentDto> instance;

    private StudentMapRepository() {
    }

    public static Map<Integer, StudentDto> getInstance() {
        if (instance == null) {
            synchronized (StudentMapRepository.class) {
                if (instance == null) {
                    instance = new HashMap<>();
                }
            }
        }
        return instance;
    }
}

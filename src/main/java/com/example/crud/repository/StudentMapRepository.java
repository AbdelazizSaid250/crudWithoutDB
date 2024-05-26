package com.example.crud.repository;

import com.example.crud.model.dto.StudentDto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Singleton Class for the HashMap with id and StudentDto.
 *
 * @author Abdelaziz Said
 */
public class StudentMapRepository {

    private static Map<String, StudentDto> instance;

    private StudentMapRepository() {
    }

    /**
     * Returns an instance of the Singleton HashMap with id and StudentDto.
     * If the instance does not exist, it creates a new instance.
     *
     * @return the instance of the Singleton HashMap with id and StudentDto.
     */
    public static Map<String, StudentDto> getInstance() {
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

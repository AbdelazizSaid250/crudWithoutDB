package com.example.crud.error.exception;

import lombok.Getter;

import java.util.NoSuchElementException;

@Getter
public class StudentNotFoundException extends NoSuchElementException {
    private final int errorCode = 10002;
    private final String errorMessage = "userNotFoundError";
    private final String description;

    public StudentNotFoundException(String description) {
        this.description = description;
    }

    public StudentNotFoundException(String message, String description) {
        super(message);
        this.description = description;
    }
}

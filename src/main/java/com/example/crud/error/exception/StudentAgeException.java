package com.example.crud.error.exception;

import lombok.Getter;

@Getter
public class StudentAgeException extends RuntimeException {
    private final int errorCode = 10001;
    private final String errorMessage = "studentAgeError";
    private final String description;

    public StudentAgeException(String description) {
        this.description = description;
    }

    public StudentAgeException(String message, String description) {
        super(message);
        this.description = description;
    }
}

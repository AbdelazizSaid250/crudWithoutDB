package com.example.crud.error.exception;

import lombok.Getter;

import java.time.format.DateTimeParseException;

@Getter
public class DateTimeValidationException extends DateTimeParseException {
    private final int errorCode = 10003;
    private final String errorMessage = "dateTimeValidationError";
    private final String description;

    public DateTimeValidationException(String message, CharSequence parsedData, int errorIndex, String description) {
        super(message, parsedData, errorIndex);
        this.description = description;
    }

}

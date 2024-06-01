package com.example.crud.util.timing;

import com.example.crud.error.exception.DateTimeValidationException;

import java.time.LocalDate;

public class DateTimeValidator {

    private DateTimeValidator() {
    }

    public static LocalDate parseDate(String date) throws DateTimeValidationException {
        return LocalDate.parse(date);
    }
}

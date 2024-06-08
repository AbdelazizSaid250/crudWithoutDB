package com.example.crud.error.exception;

import com.example.crud.error.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.crud.util.timing.TimeUtils.getCurrentTimestamp;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {

        ErrorResponse errorResponse = new ErrorResponse(10003, "validationException", exception.getFieldError().getDefaultMessage(), getCurrentTimestamp());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentAgeException.class)
    public ResponseEntity<ErrorResponse> handleStudentAgeException(StudentAgeException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage(),
                exception.getDescription(), getCurrentTimestamp());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentAgeException(StudentNotFoundException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage(),
                exception.getDescription(), getCurrentTimestamp());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DateTimeValidationException.class)
    public ResponseEntity<ErrorResponse> handleDateTimeValidationException(DateTimeValidationException exception) {
        ErrorResponse errorResponse = new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage(),
                exception.getDescription(), getCurrentTimestamp());

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

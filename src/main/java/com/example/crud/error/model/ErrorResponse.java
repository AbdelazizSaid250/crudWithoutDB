package com.example.crud.error.model;

import lombok.Value;

import java.sql.Timestamp;

@Value
public class ErrorResponse {
    int code;
    String message;
    String details;
    Timestamp timestamp;
}

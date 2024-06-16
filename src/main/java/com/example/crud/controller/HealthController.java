package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("health")
    public String health() {
        return "<h1>OK!!</h1>";
    }
}

package com.example.crud.controller.liquibase;

import com.example.crud.service.liquibase.LiquibaseService;
import liquibase.exception.LiquibaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class LiquibaseController {

    private final LiquibaseService liquibaseService;

    @Autowired
    public LiquibaseController(LiquibaseService liquibaseService) {
        this.liquibaseService = liquibaseService;
    }


    @PostMapping("/rollback")
    public void rollbackLastStep() throws SQLException, LiquibaseException {
        liquibaseService.rollbackLastStep();
    }
}

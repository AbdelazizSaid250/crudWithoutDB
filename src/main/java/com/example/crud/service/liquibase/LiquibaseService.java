package com.example.crud.service.liquibase;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Service
public class LiquibaseService {

    private static final String CLASS_NAME = LiquibaseService.class.getSimpleName();

    private final DataSource dataSource;

    @Autowired
    public LiquibaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void rollbackLastStep() throws SQLException, LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(
                new JdbcConnection(dataSource.getConnection()));
        try (Liquibase liquibase = new Liquibase("db/changelog/db.changelog-master.xml", new ClassLoaderResourceAccessor(), database)) {
            liquibase.rollback(1, String.valueOf(new Contexts()));
        } catch (Exception e) {
            log.error("Rollback last step failed", e);
            throw new LiquibaseException("Error during rollback", e);
        }
    }
}

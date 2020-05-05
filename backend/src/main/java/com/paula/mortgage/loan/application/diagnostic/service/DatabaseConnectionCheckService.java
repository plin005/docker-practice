package com.paula.mortgage.loan.application.diagnostic.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;


@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseConnectionCheckService {
    private static final String VALIDATION_QUERY_SQL = "SELECT 1";
    private final JdbcTemplate jdbcTemplate;

    public boolean isHealthy() {
        try {
            this.jdbcTemplate.query(VALIDATION_QUERY_SQL, new SingleColumnRowMapper<>());
            return true;
        } catch (Exception ex) {
            log.error("Failed to get postgresql database connection: {}", ex.toString());
            return false;
        }
    }

}


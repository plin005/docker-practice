package com.paula.mortgage.loan.application.diagnostic.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@SpringBootTest(classes = DatabaseConnectionCheckService.class)
class DatabaseConnectionCheckServiceTest {
    private JdbcTemplate jdbcTemplate;
    private DatabaseConnectionCheckService databaseConnectionCheck;

    @BeforeEach
    void setUp() {
        EmbeddedDatabaseConnection mockDB = EmbeddedDatabaseConnection.H2;
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource(
                mockDB.getUrl("testdb"),
                "sa",
                "",
                false
        );
        dataSource.setDriverClassName(mockDB.getDriverClassName());

        //Mock datasource to setup single connection for H2
        jdbcTemplate.setDataSource(dataSource);
        databaseConnectionCheck = new DatabaseConnectionCheckService(jdbcTemplate);
    }

    @Test
    void shouldReturnTrueWhenDataBaseIsHealthy() {
        // Verify
        assertThat(databaseConnectionCheck.isHealthy()).isEqualTo(false);
    }

    @Test
    void shouldReturnFalseWhenDataBaseIsNotHealthy() throws Exception {
        jdbcTemplate.getDataSource().getConnection().close();

        // Verify
        assertThat(databaseConnectionCheck.isHealthy()).isEqualTo(false);
    }

    @Test
    void shouldCloseConnectionWhenCompletedDbHealthCheck() throws Exception {
        databaseConnectionCheck.isHealthy();

        // Verify
        verify(jdbcTemplate.getDataSource().getConnection(), times(1)).close();
    }
}

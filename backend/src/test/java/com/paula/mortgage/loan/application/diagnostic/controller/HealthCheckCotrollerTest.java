package com.paula.mortgage.loan.application.diagnostic.controller;

import com.paula.mortgage.loan.application.diagnostic.service.DatabaseConnectionCheckService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HealthCheckCotroller.class)
class HealthCheckCotrollerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DatabaseConnectionCheckService databaseConnectionCheck;

    @Test
    void shouldReturnTureWhenDbIsHealthyFromCheckService() throws Exception {

        when(databaseConnectionCheck.isHealthy()).thenReturn(true);

        // Verify
        this.mvc.perform(get("/diagnostic/dbHealthCheck"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    void shouldReturnFalseWhenDbIsNotHealthyFromCheckService() throws Exception {

        when(databaseConnectionCheck.isHealthy()).thenReturn(false);

        // Verify
        this.mvc.perform(get("/diagnostic/dbHealthCheck"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }
}

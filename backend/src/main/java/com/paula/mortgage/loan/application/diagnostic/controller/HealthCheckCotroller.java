package com.paula.mortgage.loan.application.diagnostic.controller;


import com.paula.mortgage.loan.application.diagnostic.service.DatabaseConnectionCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("diagnostic")
public class HealthCheckCotroller {
    private final DatabaseConnectionCheckService databaseConnectionCheckService;

    @GetMapping("/dbHealthCheck")
    public boolean postgresqlConnection() {
        return databaseConnectionCheckService.isHealthy();
    }
}

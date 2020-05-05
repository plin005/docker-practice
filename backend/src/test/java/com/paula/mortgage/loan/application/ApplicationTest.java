package com.paula.mortgage.loan.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ApplicationTest {
    @Test
    public void contextLoads() {
        // if we made it this far, Spring has loaded our context successfully
    }
}

package com.cognizant.loan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * LoanApplication - Entry point for the Loan Microservice.
 * Runs on port 8081 (configured in application.properties)
 * since the Account service already uses the default 8080.
 */
@SpringBootApplication
public class LoanApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
        LOGGER.info("Loan Microservice started successfully");
    }
}

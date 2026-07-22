package com.cognizant.loan.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * LoanController - REST controller for loan related operations.
 * Simple dummy service without any backend database connectivity.
 */
@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    /**
     * getLoanDetails - Returns dummy loan account details based on loan number.
     * In a real scenario this would connect to a loan database.
     */
    @GetMapping("/loans/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable("number") String number) {
        LOGGER.info("Start getLoanDetails(number={})", number);

        // Dummy response as per the assignment - no database connection
        Map<String, Object> loan = new HashMap<>();
        loan.put("number", number);
        loan.put("type", "car");
        loan.put("loan", 400000);
        loan.put("emi", 3258);
        loan.put("tenure", 18);

        LOGGER.info("End getLoanDetails()");
        return loan;
    }
}

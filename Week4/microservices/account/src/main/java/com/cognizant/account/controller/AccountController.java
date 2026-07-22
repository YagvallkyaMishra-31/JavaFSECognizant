package com.cognizant.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * AccountController - REST controller for account related operations.
 * This is a simple dummy service without any backend database connectivity.
 */
@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    /**
     * getAccountDetails - Returns dummy account details based on account number.
     * In a real application this would fetch from a database.
     */
    @GetMapping("/accounts/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable("number") String number) {
        LOGGER.info("Start getAccountDetails(number={})", number);

        // Creating a dummy response - no backend connectivity as per requirement
        Map<String, Object> account = new HashMap<>();
        account.put("number", number);
        account.put("type", "savings");
        account.put("balance", 234343);

        LOGGER.info("End getAccountDetails()");
        return account;
    }
}

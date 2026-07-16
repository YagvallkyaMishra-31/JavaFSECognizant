package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController - A simple REST controller returning "Hello World!!".
 * 
 * Demonstrates basic mapping of GET requests to a resource URL (/hello).
 */
@RestController
public class HelloController {

    // SLF4J logger to log method entry and exit
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    /**
     * sayHello - Returns a hardcoded string.
     * Logs the start and end of the execution flow as requested.
     */
    @GetMapping("/hello")
    public String sayHello() {
        LOGGER.info("Start sayHello()");
        
        String helloResponse = "Hello World!!";
        
        LOGGER.info("End sayHello()");
        return helloResponse;
    }
}

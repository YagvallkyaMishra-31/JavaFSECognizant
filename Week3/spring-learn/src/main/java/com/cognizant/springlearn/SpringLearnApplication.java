package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringLearnApplication - Main boot class.
 * 
 * Demonstrates:
 * 1. Spring Boot Web startup (Hands on 1)
 * 2. Loading XML Bean context and displaying properties (Hands on 4)
 */
@SpringBootApplication
public class SpringLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        // Hands on 1: Start the Spring Boot Web application
        SpringApplication.run(SpringLearnApplication.class, args);
        
        // Log to verify if main() is successfully called and execution proceeds
        LOGGER.info("Inside main");

        // Hands on 4: Read country config and display details
        displayCountry();
    }

    /**
     * displayCountry - Loads country.xml context, fetches the Country bean,
     * and logs the country details using DEBUG level.
     */
    public static void displayCountry() {
        LOGGER.info("--- Starting displayCountry() ---");
        
        // Loads application context from class path XML
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        
        // Retrieves configured bean by ID
        Country country = context.getBean("country", Country.class);
        
        // Prints the stringified bean properties
        LOGGER.debug("Country : {}", country.toString());
        
        LOGGER.info("--- displayCountry() execution completed ---");
    }
}

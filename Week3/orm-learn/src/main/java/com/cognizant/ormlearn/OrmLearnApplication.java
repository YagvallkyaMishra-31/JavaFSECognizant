package com.cognizant.ormlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * OrmLearnApplication - Main entry point for the Spring Boot application.
 *
 * @SpringBootApplication is actually 3 annotations combined:
 *   1. @Configuration      - marks this class as a source of bean definitions
 *   2. @EnableAutoConfiguration - tells Spring Boot to auto-configure beans
 *      based on the dependencies in the classpath (like DataSource for JPA)
 *   3. @ComponentScan      - tells Spring to scan this package and sub-packages
 *      for components, services, repositories, etc.
 *
 * Basically, just adding this one annotation sets up the whole Spring context
 * automatically — that's the beauty of Spring Boot over plain Spring.
 */
@SpringBootApplication
public class OrmLearnApplication {

    // Logger for this class — using SLF4J which is the standard logging facade
    // Logback is the actual logging implementation used behind the scenes
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        // This kicks off the Spring Boot application
        // It creates the ApplicationContext, starts embedded server, wires all beans
        SpringApplication.run(OrmLearnApplication.class, args);

        // Added this log line to verify that main() completes after spring starts up
        // If we see "Inside main" in the logs, we know everything started fine
        LOGGER.info("Inside main");
    }
}

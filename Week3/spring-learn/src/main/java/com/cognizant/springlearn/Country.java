package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Country - A simple domain class representing a country.
 * 
 * We will configure an instance (bean) of this class in the country.xml file.
 * The logs inside the constructor, getters, and setters will show us exactly
 * when Spring instantiates the bean and injects the properties.
 */
public class Country {

    // SLF4J logger to print debug statements as requested by the assignment
    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;

    /**
     * Empty constructor.
     * We print a debug log here to track when Spring constructs the bean instance.
     */
    public Country() {
        LOGGER.debug("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.debug("Inside getCode method. Returning: {}", this.code);
        return code;
    }

    public void setCode(String code) {
        LOGGER.debug("Inside setCode method. Setting code: {}", code);
        this.code = code;
    }

    public String getName() {
        LOGGER.debug("Inside getName method. Returning: {}", this.name);
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName method. Setting name: {}", name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}

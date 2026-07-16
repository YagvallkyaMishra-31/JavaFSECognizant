package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * CountryService - Handles the business logic for retrieving countries.
 * 
 * It reads the list of configured countries from country.xml and 
 * provides query methods to get a specific country.
 */
@Service
public class CountryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

    private final List<Country> countries;

    /**
     * Constructor - loads context and fetches the countryList bean.
     */
    @SuppressWarnings("unchecked")
    public CountryService() {
        LOGGER.info("Initializing CountryService: loading country.xml from classpath...");
        
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        this.countries = context.getBean("countryList", List.class);
        
        LOGGER.info("CountryService loaded successfully with {} configured countries.", countries.size());
    }

    /**
     * getCountry - Searches the country list for a matching code (case-insensitive).
     * If not found, throws a ResponseStatusException returning a 404 status.
     * 
     * @param code the country code (e.g. "IN", "US")
     * @return the matching Country bean
     */
    public Country getCountry(String code) {
        LOGGER.debug("Searching for country with code: {}", code);

        // Using streams and lambda expression to do case-insensitive search
        return countries.stream()
                .filter(country -> country.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> {
                    LOGGER.warn("Country not found for code: {}", code);
                    return new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "Country not found with code: " + code
                    );
                });
    }
}

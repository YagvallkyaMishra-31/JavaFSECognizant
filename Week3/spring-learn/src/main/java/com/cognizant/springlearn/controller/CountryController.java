package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CountryController - REST API Controller exposing Country endpoints.
 */
@RestController
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    /**
     * getCountryIndia - Returns India country details.
     * Loads the 'in' bean directly from country.xml as per assignment spec.
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    public Country getCountryIndia() {
        LOGGER.info("Start getCountryIndia()");
        
        // Load context and retrieve 'in' country bean
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        Country india = context.getBean("in", Country.class);
        
        LOGGER.info("End getCountryIndia() - Returning country: {}", india.getName());
        return india;
    }

    /**
     * getCountry - Returns a specific country details matching the code path parameter.
     * 
     * @param code case-insensitive two character ISO code
     * @return the matching Country bean
     */
    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable("code") String code) {
        LOGGER.info("Start getCountry(code={})", code);
        
        Country country = countryService.getCountry(code);
        
        LOGGER.info("End getCountry(code={}) - Returning country: {}", code, country.getName());
        return country;
    }
}

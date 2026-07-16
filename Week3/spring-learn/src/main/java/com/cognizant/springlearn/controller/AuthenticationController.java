package com.cognizant.springlearn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * AuthenticationController - Exposes the /authenticate REST API endpoint 
 * to generate and return a JSON Web Token (JWT) for authenticated users.
 */
@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    /**
     * authenticate - Reads Authorization header from Basic Auth, decodes 
     * credentials, generates JWT token, and returns a JSON response: {"token": "JWT_VAL"}.
     * 
     * @param authHeader HTTP Request Header containing Basic credentials
     * @return Map containing token key-value pair
     */
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        LOGGER.debug("Authorization Header received: {}", authHeader);

        // Decode user from Authorization header
        String user = getUser(authHeader);
        LOGGER.debug("User successfully decoded: {}", user);

        // Generate JWT token for the user
        String token = generateJwt(user);
        LOGGER.info("JWT Token generated successfully");

        // Prepare JSON response payload
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);

        LOGGER.info("End authenticate()");
        return tokenMap;
    }

    /**
     * getUser - Helper method to parse Basic Auth header and decode username.
     * Expects header format: "Basic <base64EncodedCredentials>"
     */
    private String getUser(String authHeader) {
        LOGGER.info("Start getUser()");

        // Get Base64 encoded string after "Basic " prefix
        String encodedCredentials = authHeader.substring(6);
        LOGGER.debug("Encoded Credentials: {}", encodedCredentials);

        // Decode Base64 string to byte array and convert back to String
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes);
        LOGGER.debug("Decoded credentials: {}", credentials);

        // Format is "username:password" — split to extract username (text before colon)
        String user = credentials.split(":")[0];

        LOGGER.info("End getUser()");
        return user;
    }

    /**
     * generateJwt - Generates a signed JWT with subject as user, 
     * issuedAt now, expiration 20 minutes from now, signed using HS256 and secretkey.
     */
    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt()");
        LOGGER.debug("Generating token for user: {}", user);

        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        // Set the token expiry as 20 minutes from now (20 mins = 1200000 ms)
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        // Sign using HMAC SHA256 and secret key
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        
        LOGGER.info("End generateJwt()");
        return token;
    }
}

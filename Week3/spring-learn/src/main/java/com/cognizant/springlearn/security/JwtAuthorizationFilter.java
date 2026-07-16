package com.cognizant.springlearn.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

/**
 * JwtAuthorizationFilter - Intercepts all incoming requests and validates 
 * the presence of a valid JWT token in the "Authorization" header.
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
        LOGGER.info("Start JwtAuthorizationFilter Constructor");
        LOGGER.debug("AuthenticationManager initialized: {}", authenticationManager);
    }

    /**
     * Intercepts incoming requests and validates Authorization headers.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        LOGGER.info("Start doFilterInternal");
        
        String header = req.getHeader("Authorization");
        LOGGER.debug("Authorization Header: {}", header);

        // If no token or not a Bearer token, delegate to next filter
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        // Parse token and populate authentication context
        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        chain.doFilter(req, res);
        LOGGER.info("End doFilterInternal");
    }

    /**
     * getAuthentication - Extracts user details from the Bearer JWT token.
     */
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        
        if (token != null) {
            Jws<Claims> jws;
            try {
                // Parse claims using our signing key
                jws = Jwts.parser()
                        .setSigningKey("secretkey")
                        .parseClaimsJws(token.replace("Bearer ", ""));
                
                String user = jws.getBody().getSubject();
                LOGGER.debug("Parsed Username from JWT: {}", user);
                
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }
            } catch (JwtException ex) {
                LOGGER.warn("Failed to parse JWT token: {}", ex.getMessage());
                return null;
            }
        }
        return null;
    }
}

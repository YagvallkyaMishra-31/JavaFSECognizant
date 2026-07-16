package com.cognizant.springlearn.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SecurityConfig - Configures Spring Security for the application.
 * 
 * Sets up basic authentication for generating JWT tokens and registers 
 * the JWT filter to authorize all other web services.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    /**
     * Configure in-memory authentication with two users: admin and user.
     * Both have password "pwd" which is encrypted using BCrypt.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        LOGGER.info("Start configuring AuthenticationManagerBuilder");
        
        auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
            .and()
            .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
            
        LOGGER.info("End configuring AuthenticationManagerBuilder");
    }

    /**
     * passwordEncoder - Register BCryptPasswordEncoder as a bean to hash passwords.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Start passwordEncoder()");
        return new BCryptPasswordEncoder();
    }

    /**
     * Configure HTTP security rules:
     * - Disable CSRF
     * - Enable HTTP Basic Auth (required for retrieving the JWT token at /authenticate)
     * - Protect /authenticate endpoint so only authenticated USER/ADMIN can access it
     * - Protect all other requests so they require authorization
     * - Add JwtAuthorizationFilter to validate incoming JWTs
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        LOGGER.info("Start configuring HttpSecurity");
        
        httpSecurity.csrf().disable()
            .httpBasic().and()
            .authorizeRequests()
            .antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
            .anyRequest().authenticated()
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManager()));
            
        LOGGER.info("End configuring HttpSecurity");
    }
}

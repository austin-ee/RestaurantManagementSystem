/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aust.RestaurantMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 *
 * @author steve
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Autowired
    CustormUserDetailsService custormUserDetails;
    
    @Bean
    public AuthenticationManager authManager() throws Exception {
       return new ProviderManager(authenticationProvider());
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
       authenticationProvider.setUserDetailsService(custormUserDetails);
       authenticationProvider.setPasswordEncoder(passwordEncoder());
       return authenticationProvider;
    }
    @Bean                        
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF 
            .authorizeHttpRequests(auth -> {
                auth
                    .requestMatchers("/aust/api/login","aust/api/register").permitAll() // Allow login without authentication
                    .anyRequest().authenticated(); // Other requests require authentication
            });
        
        return http.build();
    } 

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12); // Use BCrypt for password encoding
    }
}

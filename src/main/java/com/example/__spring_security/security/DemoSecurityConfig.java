package com.example.__spring_security.security;
//NOW USE USERS FROM SECURITY CONFIGURATION

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration

//Add users, passwords and roles
public class DemoSecurityConfig {

    //To store user details locally in Memory
//ADD SUPPORT FOR JDBC .. No more hardcoded users
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
        //Return new, new returns an object..,JdbcUserDetailsManager inbuilt class, return an object of that for using

    }

    //Spring Security know exact columns to check, we inject the datasource and return the datasource

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
        //Return object of class BCryptPasswordEncoder for using as can't use class.. but classes are predefined
    }


    //So that Spring security can convert entered password to hash






//For creating custom Login Page, need to  create a controller(Handles api) for login page that renders the html
    //Automatically provides with another api that handles authentication, no need to create controller but create a post request in HTML file.


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Disable security for testing purposes
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .anyRequest().permitAll()
                )
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable();

        return http.build();
    }

}

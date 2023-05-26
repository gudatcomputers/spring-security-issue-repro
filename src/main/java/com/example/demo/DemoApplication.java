package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableMethodSecurity
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /*
        This causes the event of each type
         */
//        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().permitAll());

        /*
        This generates 2 AuthorizationDeniedEvent
         */
        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().hasRole("admin"));
        return httpSecurity.build();
    }
}

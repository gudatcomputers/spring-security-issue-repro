package com.example.demo;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationEventLoggingController {

    @GetMapping("/open-access")
    void openAccess() {
        System.out.println("OPEN ACCESS");
    }

    @GetMapping("/privileged-access")
    @PreAuthorize("hasRole('admin')")
    void privilegedAccess() {
        System.out.println("ADMIN ACCESS");
    }
}

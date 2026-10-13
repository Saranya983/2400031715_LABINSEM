package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password123";

    @PostMapping("/auth/login-static")
    public Map<String, String> login(
            @RequestBody Map<String, String> input) {

        String username = input.get("username");
        String password = input.get("password");

        if (USERNAME.equals(username)
                && PASSWORD.equals(password)) {

            return Map.of(
                "message", "Authentication Successful",
                "status", "200"
            );
        }

        throw new org.springframework.web.server.ResponseStatusException(
            org.springframework.http.HttpStatus.UNAUTHORIZED,
            "Authentication Failed"
        );
    }
}
package com.mergingtonhigh.schoolmanagement.presentation.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mergingtonhigh.schoolmanagement.application.dtos.TeacherDTO;
import com.mergingtonhigh.schoolmanagement.application.usecases.AuthenticationUseCase;

/**
 * REST controller for authentication endpoints.
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthenticationUseCase authenticationUseCase;

    public AuthController(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    /**
     * Login a teacher account.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            TeacherDTO teacher = authenticationUseCase.login(username, password);
            return ResponseEntity.ok(teacher);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401)
                    .body(Map.of("detail", "Invalid username or password"));
        }
    }

    /**
     * Check if a session is valid by username.
     */
    @GetMapping("/check-session")
    public ResponseEntity<?> checkSession(@RequestParam String username) {
        try {
            TeacherDTO teacher = authenticationUseCase.checkSession(username);
            return ResponseEntity.ok(teacher);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404)
                    .body(Map.of("detail", "Teacher not found"));
        }
    }
}
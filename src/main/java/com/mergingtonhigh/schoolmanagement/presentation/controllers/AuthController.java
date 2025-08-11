package com.mergingtonhigh.schoolmanagement.presentation.controllers;

import com.mergingtonhigh.schoolmanagement.application.dtos.LoginRequestDTO;
import com.mergingtonhigh.schoolmanagement.application.dtos.TeacherDTO;
import com.mergingtonhigh.schoolmanagement.application.usecases.AuthenticationUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
package com.mergingtonhigh.schoolmanagement.presentation.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mergingtonhigh.schoolmanagement.application.dtos.ActivityDTO;
import com.mergingtonhigh.schoolmanagement.application.usecases.ActivityUseCase;
import com.mergingtonhigh.schoolmanagement.application.usecases.StudentRegistrationUseCase;

/**
 * REST controller for activity management endpoints.
 */
@RestController
@RequestMapping("/activities")
@CrossOrigin(origins = "*")
public class ActivityController {

    private final ActivityUseCase activityUseCase;
    private final StudentRegistrationUseCase studentRegistrationUseCase;

    public ActivityController(ActivityUseCase activityUseCase,
            StudentRegistrationUseCase studentRegistrationUseCase) {
        this.activityUseCase = activityUseCase;
        this.studentRegistrationUseCase = studentRegistrationUseCase;
    }

    /**
     * Get all activities with optional filtering by day and time.
     */
    @GetMapping
    public ResponseEntity<Map<String, ActivityDTO>> getActivities(
            @RequestParam(required = false) String day,
            @RequestParam(name = "start_time", required = false) String startTime,
            @RequestParam(name = "end_time", required = false) String endTime) {

        Map<String, ActivityDTO> activities = activityUseCase.getActivities(day, startTime, endTime);
        return ResponseEntity.ok(activities);
    }

    /**
     * Get all days that have activities scheduled.
     */
    @GetMapping("/days")
    public ResponseEntity<List<String>> getAvailableDays() {
        List<String> days = activityUseCase.getAvailableDays();
        return ResponseEntity.ok(days);
    }

    /**
     * Sign up a student for an activity.
     */
    @PostMapping("/{activityName}/signup")
    public ResponseEntity<Map<String, String>> signupForActivity(
            @PathVariable String activityName,
            @RequestParam String email,
            @RequestParam(name = "teacher_username", required = false) String teacherUsername) {

        if (teacherUsername == null || teacherUsername.trim().isEmpty()) {
            return ResponseEntity.status(401)
                    .body(Map.of("detail", "Authentication required for this action"));
        }

        try {
            String message = studentRegistrationUseCase.signupForActivity(activityName, email, teacherUsername);
            return ResponseEntity.ok(Map.of("message", message));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("credentials")) {
                return ResponseEntity.status(401).body(Map.of("detail", e.getMessage()));
            } else if (e.getMessage().contains("not found")) {
                return ResponseEntity.status(404).body(Map.of("detail", e.getMessage()));
            } else {
                return ResponseEntity.status(400).body(Map.of("detail", e.getMessage()));
            }
        } catch (IllegalStateException e) {
            return ResponseEntity.status(400).body(Map.of("detail", e.getMessage()));
        }
    }

    /**
     * Unregister a student from an activity.
     */
    @PostMapping("/{activityName}/unregister")
    public ResponseEntity<Map<String, String>> unregisterFromActivity(
            @PathVariable String activityName,
            @RequestParam String email,
            @RequestParam(name = "teacher_username", required = false) String teacherUsername) {

        if (teacherUsername == null || teacherUsername.trim().isEmpty()) {
            return ResponseEntity.status(401)
                    .body(Map.of("detail", "Authentication required for this action"));
        }

        try {
            String message = studentRegistrationUseCase.unregisterFromActivity(activityName, email, teacherUsername);
            return ResponseEntity.ok(Map.of("message", message));
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("credentials")) {
                return ResponseEntity.status(401).body(Map.of("detail", e.getMessage()));
            } else if (e.getMessage().contains("not found")) {
                return ResponseEntity.status(404).body(Map.of("detail", e.getMessage()));
            } else {
                return ResponseEntity.status(400).body(Map.of("detail", e.getMessage()));
            }
        }
    }
}
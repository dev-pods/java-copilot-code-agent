package com.mergingtonhigh.schoolmanagement.application.usecases;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.Email;
import org.springframework.stereotype.Service;

/**
 * Use case for student registration in activities.
 */
@Service
public class StudentRegistrationUseCase {
    
    private final ActivityRepository activityRepository;
    private final TeacherRepository teacherRepository;
    
    public StudentRegistrationUseCase(ActivityRepository activityRepository, TeacherRepository teacherRepository) {
        this.activityRepository = activityRepository;
        this.teacherRepository = teacherRepository;
    }
    
    /**
     * Sign up a student for an activity.
     */
    public String signupForActivity(String activityName, String email, String teacherUsername) {
        // Validate teacher authentication
        Teacher teacher = teacherRepository.findByUsername(teacherUsername)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher credentials"));
        
        // Get the activity
        Activity activity = activityRepository.findByName(activityName)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
        
        // Create email value object and add participant
        Email studentEmail = new Email(email);
        activity.addParticipant(studentEmail);
        
        // Save the updated activity
        activityRepository.save(activity);
        
        return String.format("Signed up %s for %s", email, activityName);
    }
    
    /**
     * Unregister a student from an activity.
     */
    public String unregisterFromActivity(String activityName, String email, String teacherUsername) {
        // Validate teacher authentication
        Teacher teacher = teacherRepository.findByUsername(teacherUsername)
                .orElseThrow(() -> new IllegalArgumentException("Invalid teacher credentials"));
        
        // Get the activity
        Activity activity = activityRepository.findByName(activityName)
                .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
        
        // Create email value object and remove participant
        Email studentEmail = new Email(email);
        activity.removeParticipant(studentEmail);
        
        // Save the updated activity
        activityRepository.save(activity);
        
        return String.format("Unregistered %s from %s", email, activityName);
    }
}
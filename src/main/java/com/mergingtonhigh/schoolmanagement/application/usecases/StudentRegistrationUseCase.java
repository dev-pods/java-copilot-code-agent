package com.mergingtonhigh.schoolmanagement.application.usecases;

import org.springframework.stereotype.Service;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.Email;

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
        teacherRepository.findByUsername(teacherUsername)
                .orElseThrow(() -> new IllegalArgumentException("Credenciais de professor inválidas"));

        // Get the activity
        Activity activity = activityRepository.findByName(activityName)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada"));

        // Create email value object and add participant
        Email studentEmail = new Email(email);
        activity.addParticipant(studentEmail);

        // Save the updated activity
        activityRepository.save(activity);

        return String.format("Inscrito %s para %s", email, activityName);
    }

    /**
     * Unregister a student from an activity.
     */
    public String unregisterFromActivity(String activityName, String email, String teacherUsername) {
        // Validate teacher authentication
        teacherRepository.findByUsername(teacherUsername)
                .orElseThrow(() -> new IllegalArgumentException("Credenciais de professor inválidas"));

        // Get the activity
        Activity activity = activityRepository.findByName(activityName)
                .orElseThrow(() -> new IllegalArgumentException("Atividade não encontrada"));

        // Create email value object and remove participant
        Email studentEmail = new Email(email);
        activity.removeParticipant(studentEmail);

        // Save the updated activity
        activityRepository.save(activity);

        return String.format("Desinscrito %s de %s", email, activityName);
    }
}
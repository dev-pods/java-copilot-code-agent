package com.mergingtonhigh.schoolmanagement.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

/**
 * Unit tests for StudentRegistrationUseCase.
 */
@ExtendWith(MockitoExtension.class)
class StudentRegistrationUseCaseTest {

    @Mock
    private ActivityRepository activityRepository;

    @Mock
    private TeacherRepository teacherRepository;

    private StudentRegistrationUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new StudentRegistrationUseCase(activityRepository, teacherRepository);
    }

    @Test
    void shouldSignupStudentForActivitySuccessfully() {
        // Arrange
        String activityName = "Clube de Xadrez";
        String email = "student@mergington.edu";
        String teacherUsername = "teacher1";

        Teacher teacher = new Teacher(teacherUsername, "Teacher", "password", Teacher.Role.TEACHER);
        Activity activity = createTestActivity(activityName);

        when(teacherRepository.findByUsername(teacherUsername)).thenReturn(Optional.of(teacher));
        when(activityRepository.findByName(activityName)).thenReturn(Optional.of(activity));
        when(activityRepository.save(any(Activity.class))).thenReturn(activity);

        // Act
        String result = useCase.signupForActivity(activityName, email, teacherUsername);

        // Assert
        assertEquals("Inscrito student@mergington.edu para Clube de Xadrez", result);
        verify(activityRepository).save(activity);
        assertTrue(activity.getParticipants().contains(email));
    }

    @Test
    void shouldThrowExceptionWhenTeacherNotFound() {
        // Arrange
        String activityName = "Clube de Xadrez";
        String email = "student@mergington.edu";
        String teacherUsername = "nonexistent";

        when(teacherRepository.findByUsername(teacherUsername)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> useCase.signupForActivity(activityName, email, teacherUsername));

        verify(activityRepository, never()).findByName(any());
        verify(activityRepository, never()).save(any());
    }

    @Test
    void shouldThrowExceptionWhenActivityNotFound() {
        // Arrange
        String activityName = "Atividade Inexistente";
        String email = "student@mergington.edu";
        String teacherUsername = "teacher1";

        Teacher teacher = new Teacher(teacherUsername, "Teacher", "password", Teacher.Role.TEACHER);

        when(teacherRepository.findByUsername(teacherUsername)).thenReturn(Optional.of(teacher));
        when(activityRepository.findByName(activityName)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> useCase.signupForActivity(activityName, email, teacherUsername));

        verify(activityRepository, never()).save(any());
    }

    @Test
    void shouldUnregisterStudentFromActivitySuccessfully() {
        // Arrange
        String activityName = "Clube de Xadrez";
        String email = "student@mergington.edu";
        String teacherUsername = "teacher1";

        Teacher teacher = new Teacher(teacherUsername, "Teacher", "password", Teacher.Role.TEACHER);
        Activity activity = createTestActivity(activityName);
        activity.setParticipants(List.of(email));

        when(teacherRepository.findByUsername(teacherUsername)).thenReturn(Optional.of(teacher));
        when(activityRepository.findByName(activityName)).thenReturn(Optional.of(activity));
        when(activityRepository.save(any(Activity.class))).thenReturn(activity);

        // Act
        String result = useCase.unregisterFromActivity(activityName, email, teacherUsername);

        // Assert
        assertEquals("Desinscrito student@mergington.edu de Clube de Xadrez", result);
        verify(activityRepository).save(activity);
        assertFalse(activity.getParticipants().contains(email));
    }

    private Activity createTestActivity(String name) {
        ScheduleDetails schedule = new ScheduleDetails(
                List.of("Monday"),
                LocalTime.of(15, 30),
                LocalTime.of(17, 0));

        return new Activity(
                name,
                "Descrição de teste",
                "Seg 15:30-17:00",
                schedule,
                12,
                ActivityType.ACADEMIC);
    }
}
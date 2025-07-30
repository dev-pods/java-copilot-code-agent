package com.mergingtonhigh.schoolmanagement.domain.entities;

import com.mergingtonhigh.schoolmanagement.domain.valueobjects.Email;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Activity domain entity.
 */
class ActivityTest {
    
    @Test
    void shouldCreateActivityWithValidData() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
            List.of("Monday", "Wednesday"), 
            LocalTime.of(15, 30), 
            LocalTime.of(17, 0)
        );
        
        // Act
        Activity activity = new Activity(
            "Chess Club",
            "Learn chess strategies",
            "Mon/Wed 3:30-5:00 PM",
            schedule,
            12
        );
        
        // Assert
        assertEquals("Chess Club", activity.getName());
        assertEquals("Learn chess strategies", activity.getDescription());
        assertEquals(12, activity.getMaxParticipants());
        assertEquals(0, activity.getCurrentParticipantCount());
        assertTrue(activity.canAddParticipant());
    }
    
    @Test
    void shouldThrowExceptionWhenNameIsNull() {
        // Arrange
        ScheduleDetails schedule = new ScheduleDetails(
            List.of("Monday"), 
            LocalTime.of(15, 30), 
            LocalTime.of(17, 0)
        );
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            new Activity(null, "Description", "Schedule", schedule, 12)
        );
    }
    
    @Test
    void shouldAddParticipantSuccessfully() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        
        // Act
        activity.addParticipant(studentEmail);
        
        // Assert
        assertEquals(1, activity.getCurrentParticipantCount());
        assertTrue(activity.isParticipantRegistered(studentEmail));
    }
    
    @Test
    void shouldThrowExceptionWhenAddingDuplicateParticipant() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        activity.addParticipant(studentEmail);
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            activity.addParticipant(studentEmail)
        );
    }
    
    @Test
    void shouldRemoveParticipantSuccessfully() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        activity.addParticipant(studentEmail);
        
        // Act
        activity.removeParticipant(studentEmail);
        
        // Assert
        assertEquals(0, activity.getCurrentParticipantCount());
        assertFalse(activity.isParticipantRegistered(studentEmail));
    }
    
    @Test
    void shouldThrowExceptionWhenRemovingNonExistentParticipant() {
        // Arrange
        Activity activity = createTestActivity();
        Email studentEmail = new Email("student@mergington.edu");
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> 
            activity.removeParticipant(studentEmail)
        );
    }
    
    private Activity createTestActivity() {
        ScheduleDetails schedule = new ScheduleDetails(
            List.of("Monday"), 
            LocalTime.of(15, 30), 
            LocalTime.of(17, 0)
        );
        
        return new Activity(
            "Test Activity",
            "Test Description",
            "Mon 3:30-5:00 PM",
            schedule,
            12
        );
    }
}
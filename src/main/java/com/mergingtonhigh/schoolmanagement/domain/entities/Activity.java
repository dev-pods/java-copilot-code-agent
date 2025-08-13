package com.mergingtonhigh.schoolmanagement.domain.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ActivityType;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.Email;
import com.mergingtonhigh.schoolmanagement.domain.valueobjects.ScheduleDetails;

/**
 * Domain entity representing an extracurricular activity.
 */
@Document(collection = "activities")
public class Activity {

    @Id
    private String name;
    private String description;
    private String schedule;
    private ScheduleDetails scheduleDetails;
    private int maxParticipants;
    private List<String> participants;
    private ActivityType type;

    public Activity() {
        this.participants = new ArrayList<>();
    }

    public Activity(String name, String description, String schedule,
            ScheduleDetails scheduleDetails, int maxParticipants, ActivityType type) {
        this.name = validateName(name);
        this.description = validateDescription(description);
        this.schedule = schedule;
        this.scheduleDetails = scheduleDetails;
        this.maxParticipants = validateMaxParticipants(maxParticipants);
        this.participants = new ArrayList<>();
        this.type = type != null ? type : ActivityType.determineFromContent(name, description);
    }

    public boolean canAddParticipant() {
        return participants.size() < maxParticipants;
    }

    public boolean isParticipantRegistered(Email email) {
        return participants.contains(email.value());
    }

    public void addParticipant(Email email) {
        if (!canAddParticipant()) {
            throw new IllegalStateException("Activity is at maximum capacity");
        }
        if (isParticipantRegistered(email)) {
            throw new IllegalArgumentException("Student is already registered for this activity");
        }
        participants.add(email.value());
    }

    public void removeParticipant(Email email) {
        if (!isParticipantRegistered(email)) {
            throw new IllegalArgumentException("Student is not registered for this activity");
        }
        participants.remove(email.value());
    }

    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Activity name cannot be null or empty");
        }
        return name.trim();
    }

    private String validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Activity description cannot be null or empty");
        }
        return description.trim();
    }

    private int validateMaxParticipants(int maxParticipants) {
        if (maxParticipants <= 0) {
            throw new IllegalArgumentException("Max participants must be greater than 0");
        }
        return maxParticipants;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = validateDescription(description);
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public ScheduleDetails getScheduleDetails() {
        return scheduleDetails;
    }

    public void setScheduleDetails(ScheduleDetails scheduleDetails) {
        this.scheduleDetails = scheduleDetails;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = validateMaxParticipants(maxParticipants);
    }

    public List<String> getParticipants() {
        return new ArrayList<>(participants);
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants != null ? new ArrayList<>(participants) : new ArrayList<>();
    }

    public int getCurrentParticipantCount() {
        return participants.size();
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type != null ? type : ActivityType.determineFromContent(this.name, this.description);
    }
}
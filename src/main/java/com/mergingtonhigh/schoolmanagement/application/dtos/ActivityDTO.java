package com.mergingtonhigh.schoolmanagement.application.dtos;

import java.util.List;

/**
 * DTO for activity data transfer.
 */
public record ActivityDTO(
        String name,
        String description,
        String schedule,
        ScheduleDetailsDTO scheduleDetails,
        int maxParticipants,
        List<String> participants,
        int currentParticipantCount,
        ActivityTypeDTO type) {
    public record ScheduleDetailsDTO(
            List<String> days,
            String startTime,
            String endTime) {
    }
}
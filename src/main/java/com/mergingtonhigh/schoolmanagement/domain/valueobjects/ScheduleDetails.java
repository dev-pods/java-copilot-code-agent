package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

import java.time.LocalTime;
import java.util.List;

/**
 * Value object representing schedule details for an activity.
 */
public record ScheduleDetails(
    List<String> days,
    LocalTime startTime,
    LocalTime endTime
) {
    public ScheduleDetails {
        if (days == null || days.isEmpty()) {
            throw new IllegalArgumentException("Days cannot be null or empty");
        }
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("End time cannot be null");
        }
        if (startTime.isAfter(endTime)) {
            throw new IllegalArgumentException("Start time cannot be after end time");
        }
    }
}
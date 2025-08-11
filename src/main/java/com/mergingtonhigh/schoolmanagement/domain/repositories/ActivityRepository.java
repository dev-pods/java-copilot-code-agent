package com.mergingtonhigh.schoolmanagement.domain.repositories;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Activity domain entity.
 */
public interface ActivityRepository {
    
    /**
     * Find all activities.
     */
    List<Activity> findAll();
    
    /**
     * Find activity by name.
     */
    Optional<Activity> findByName(String name);
    
    /**
     * Find activities by day.
     */
    List<Activity> findByDay(String day);
    
    /**
     * Find activities within time range.
     */
    List<Activity> findByTimeRange(LocalTime startTime, LocalTime endTime);
    
    /**
     * Find activities by day and time range.
     */
    List<Activity> findByDayAndTimeRange(String day, LocalTime startTime, LocalTime endTime);
    
    /**
     * Get all unique days that have activities.
     */
    List<String> findAllUniqueDays();
    
    /**
     * Save an activity.
     */
    Activity save(Activity activity);
    
    /**
     * Delete an activity by name.
     */
    void deleteByName(String name);
    
    /**
     * Check if activity exists by name.
     */
    boolean existsByName(String name);
}
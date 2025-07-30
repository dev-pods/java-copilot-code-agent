package com.mergingtonhigh.schoolmanagement.infrastructure.persistence;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

/**
 * Spring Data MongoDB repository for Activity entities.
 */
@Repository
public interface MongoActivityRepository extends MongoRepository<Activity, String> {
    
    @Query("{ 'scheduleDetails.days': { $in: [?0] } }")
    List<Activity> findByScheduleDetailsDays(String day);
    
    @Query("{ 'scheduleDetails.startTime': { $gte: ?0 }, 'scheduleDetails.endTime': { $lte: ?1 } }")
    List<Activity> findByScheduleDetailsTimeRange(LocalTime startTime, LocalTime endTime);
    
    @Query("{ 'scheduleDetails.days': { $in: [?0] }, 'scheduleDetails.startTime': { $gte: ?1 }, 'scheduleDetails.endTime': { $lte: ?2 } }")
    List<Activity> findByScheduleDetailsDaysAndTimeRange(String day, LocalTime startTime, LocalTime endTime);
}
package com.mergingtonhigh.schoolmanagement.infrastructure.persistence;

import com.mergingtonhigh.schoolmanagement.domain.entities.Activity;
import com.mergingtonhigh.schoolmanagement.domain.repositories.ActivityRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of ActivityRepository using MongoDB.
 */
@Repository
public class ActivityRepositoryImpl implements ActivityRepository {
    
    private final MongoActivityRepository mongoRepository;
    private final MongoTemplate mongoTemplate;
    
    public ActivityRepositoryImpl(MongoActivityRepository mongoRepository, MongoTemplate mongoTemplate) {
        this.mongoRepository = mongoRepository;
        this.mongoTemplate = mongoTemplate;
    }
    
    @Override
    public List<Activity> findAll() {
        return mongoRepository.findAll();
    }
    
    @Override
    public Optional<Activity> findByName(String name) {
        return mongoRepository.findById(name);
    }
    
    @Override
    public List<Activity> findByDay(String day) {
        return mongoRepository.findByScheduleDetailsDays(day);
    }
    
    @Override
    public List<Activity> findByTimeRange(LocalTime startTime, LocalTime endTime) {
        return mongoRepository.findByScheduleDetailsTimeRange(startTime, endTime);
    }
    
    @Override
    public List<Activity> findByDayAndTimeRange(String day, LocalTime startTime, LocalTime endTime) {
        return mongoRepository.findByScheduleDetailsDaysAndTimeRange(day, startTime, endTime);
    }
    
    @Override
    public List<String> findAllUniqueDays() {
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.unwind("scheduleDetails.days"),
            Aggregation.group().addToSet("scheduleDetails.days").as("days"),
            Aggregation.unwind("days"),
            Aggregation.sort(org.springframework.data.domain.Sort.by("days"))
        );
        
        AggregationResults<String> results = mongoTemplate.aggregate(
            aggregation, "activities", String.class);
        
        return results.getMappedResults();
    }
    
    @Override
    public Activity save(Activity activity) {
        return mongoRepository.save(activity);
    }
    
    @Override
    public void deleteByName(String name) {
        mongoRepository.deleteById(name);
    }
    
    @Override
    public boolean existsByName(String name) {
        return mongoRepository.existsById(name);
    }
}
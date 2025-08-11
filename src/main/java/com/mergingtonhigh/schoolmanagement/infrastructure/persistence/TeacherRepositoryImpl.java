package com.mergingtonhigh.schoolmanagement.infrastructure.persistence;

import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of TeacherRepository using MongoDB.
 */
@Repository
public class TeacherRepositoryImpl implements TeacherRepository {
    
    private final MongoTeacherRepository mongoRepository;
    
    public TeacherRepositoryImpl(MongoTeacherRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }
    
    @Override
    public List<Teacher> findAll() {
        return mongoRepository.findAll();
    }
    
    @Override
    public Optional<Teacher> findByUsername(String username) {
        return mongoRepository.findById(username);
    }
    
    @Override
    public Teacher save(Teacher teacher) {
        return mongoRepository.save(teacher);
    }
    
    @Override
    public void deleteByUsername(String username) {
        mongoRepository.deleteById(username);
    }
    
    @Override
    public boolean existsByUsername(String username) {
        return mongoRepository.existsById(username);
    }
}
package com.mergingtonhigh.schoolmanagement.domain.repositories;

import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Teacher domain entity.
 */
public interface TeacherRepository {
    
    /**
     * Find all teachers.
     */
    List<Teacher> findAll();
    
    /**
     * Find teacher by username.
     */
    Optional<Teacher> findByUsername(String username);
    
    /**
     * Save a teacher.
     */
    Teacher save(Teacher teacher);
    
    /**
     * Delete a teacher by username.
     */
    void deleteByUsername(String username);
    
    /**
     * Check if teacher exists by username.
     */
    boolean existsByUsername(String username);
}
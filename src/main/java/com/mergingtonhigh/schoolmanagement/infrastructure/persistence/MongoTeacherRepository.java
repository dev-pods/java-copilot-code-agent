package com.mergingtonhigh.schoolmanagement.infrastructure.persistence;

import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data MongoDB repository for Teacher entities.
 */
@Repository
public interface MongoTeacherRepository extends MongoRepository<Teacher, String> {
}
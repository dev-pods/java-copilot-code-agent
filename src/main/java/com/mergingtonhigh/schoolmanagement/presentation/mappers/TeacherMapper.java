package com.mergingtonhigh.schoolmanagement.presentation.mappers;

import com.mergingtonhigh.schoolmanagement.application.dtos.TeacherDTO;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Teacher entity and TeacherDTO.
 */
@Component
public class TeacherMapper {
    
    public TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        
        return new TeacherDTO(
            teacher.getUsername(),
            teacher.getDisplayName(),
            teacher.getRole().name().toLowerCase()
        );
    }
}
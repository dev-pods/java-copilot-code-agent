package com.mergingtonhigh.schoolmanagement.application.usecases;

import com.mergingtonhigh.schoolmanagement.application.dtos.TeacherDTO;
import com.mergingtonhigh.schoolmanagement.domain.entities.Teacher;
import com.mergingtonhigh.schoolmanagement.domain.repositories.TeacherRepository;
import com.mergingtonhigh.schoolmanagement.presentation.mappers.TeacherMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Use case for teacher authentication.
 */
@Service
public class AuthenticationUseCase {
    
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherMapper teacherMapper;
    
    public AuthenticationUseCase(TeacherRepository teacherRepository, 
                               PasswordEncoder passwordEncoder,
                               TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.teacherMapper = teacherMapper;
    }
    
    /**
     * Authenticate a teacher login.
     */
    public TeacherDTO login(String username, String password) {
        Teacher teacher = teacherRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        
        if (!passwordEncoder.matches(password, teacher.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        
        return teacherMapper.toDTO(teacher);
    }
    
    /**
     * Check if a session is valid by username.
     */
    public TeacherDTO checkSession(String username) {
        Teacher teacher = teacherRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found"));
        
        return teacherMapper.toDTO(teacher);
    }
}
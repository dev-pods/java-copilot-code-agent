package com.mergingtonhigh.schoolmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.mongock.runner.springboot.EnableMongock;

/**
 * Main application class for the Mergington High School Management System.
 * 
 * A Spring Boot application that manages extracurricular activities and student
 * registrations.
 */
@EnableMongock
@SpringBootApplication
public class SchoolManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolManagementSystemApplication.class, args);
    }
}
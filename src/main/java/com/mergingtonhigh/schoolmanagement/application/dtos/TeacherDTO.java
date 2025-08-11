package com.mergingtonhigh.schoolmanagement.application.dtos;

/**
 * DTO for teacher authentication data transfer.
 */
public record TeacherDTO(
    String username,
    String displayName,
    String role
) {}
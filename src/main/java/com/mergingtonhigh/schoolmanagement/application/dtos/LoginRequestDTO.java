package com.mergingtonhigh.schoolmanagement.application.dtos;

/**
 * DTO for login requests.
 */
public record LoginRequestDTO(
    String username,
    String password
) {}
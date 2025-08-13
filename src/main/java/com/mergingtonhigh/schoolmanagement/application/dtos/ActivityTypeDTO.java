package com.mergingtonhigh.schoolmanagement.application.dtos;

/**
 * DTO for ActivityType data transfer.
 */
public record ActivityTypeDTO(
        String name,
        String label,
        String color,
        String textColor) {
}

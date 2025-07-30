package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

/**
 * Value object representing an email address.
 */
public record Email(String value) {
    public Email {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (!isValidEmail(value.trim())) {
            throw new IllegalArgumentException("Invalid email format");
        }
        value = value.trim().toLowerCase();
    }
    
    private static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    @Override
    public String toString() {
        return value;
    }
}
package com.mergingtonhigh.schoolmanagement.domain.valueobjects;

/**
 * Enum representing the different types of activities.
 * Each type has a label for display purposes and color information for UI.
 */
public enum ActivityType {
    SPORTS("Esportes", "#e8f5e9", "#2e7d32"),
    ARTS("Artes", "#f3e5f5", "#7b1fa2"),
    ACADEMIC("Acadêmico", "#e3f2fd", "#1565c0"),
    COMMUNITY("Comunidade", "#fff3e0", "#e65100"),
    TECHNOLOGY("Tecnologia", "#e8eaf6", "#3949ab");

    private final String label;
    private final String color;
    private final String textColor;

    ActivityType(String label, String color, String textColor) {
        this.label = label;
        this.color = color;
        this.textColor = textColor;
    }

    public String getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }

    public String getTextColor() {
        return textColor;
    }

    /**
     * Automatically determines the activity type based on name and description.
     * This method contains the same logic that was previously in the frontend.
     */
    public static ActivityType determineFromContent(String name, String description) {
        if (name == null && description == null) {
            return ACADEMIC; // Default
        }

        String lowerName = name != null ? name.toLowerCase() : "";
        String lowerDesc = description != null ? description.toLowerCase() : "";

        // Sports keywords
        if (containsAny(lowerName, "futebol", "basquete", "esporte", "fitness", "soccer", "basketball", "sport") ||
                containsAny(lowerDesc, "equipe", "time", "jogo", "atlético", "team", "game", "athletic")) {
            return SPORTS;
        }

        // Arts keywords
        if (containsAny(lowerName, "arte", "música", "teatro", "drama", "art", "music", "theater") ||
                containsAny(lowerDesc, "criativo", "pintura", "creative", "paint")) {
            return ARTS;
        }

        // Academic keywords
        if (containsAny(lowerName, "ciência", "matemática", "acadêmico", "estudo", "olimpíada", "science", "math",
                "academic", "study", "olympiad") ||
                containsAny(lowerDesc, "aprendizado", "educação", "competição", "learning", "education",
                        "competition")) {
            return ACADEMIC;
        }

        // Community keywords
        if (containsAny(lowerName, "voluntário", "comunidade", "volunteer", "community") ||
                containsAny(lowerDesc, "serviço", "voluntário", "service", "volunteer")) {
            return COMMUNITY;
        }

        // Technology keywords
        if (containsAny(lowerName, "computador", "programação", "tecnologia", "robótica", "computer", "coding", "tech",
                "robotics") ||
                containsAny(lowerDesc, "programação", "tecnologia", "digital", "robô", "programming", "technology",
                        "robot")) {
            return TECHNOLOGY;
        }

        return ACADEMIC; // Default fallback
    }

    /**
     * Helper method to check if a string contains any of the given keywords.
     */
    private static boolean containsAny(String text, String... keywords) {
        if (text == null)
            return false;
        for (String keyword : keywords) {
            if (text.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}

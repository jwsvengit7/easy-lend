package com.decagon.enums;

public enum JobType {
    FULL_TIME("Full-time"),
    PART_TIME("Part-time"),
    CONTRACT("Contract"),
    FREELANCE("Freelance"),
    TEMPORARY("Temporary"),
    OTHER("Other");

    private String description;

    JobType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


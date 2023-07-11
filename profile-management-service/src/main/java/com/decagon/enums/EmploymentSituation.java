package com.decagon.enums;

public enum EmploymentSituation {
    EMPLOYED("Employed"),
    SELF_EMPLOYED("Self-employed"),
    UNEMPLOYED("Unemployed"),
    STUDENT("Student"),
    OTHER("Other");

    private String description;

    EmploymentSituation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


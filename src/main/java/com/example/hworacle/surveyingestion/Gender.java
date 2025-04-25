package com.example.hworacle.surveyingestion;

public enum Gender {
    MALE,
    FEMALE,
    OTHER,
    UNKNOWN;

    public static Gender from(final String gender) {
        if (gender == null) {
            return UNKNOWN;
        }
        switch (gender.trim().toLowerCase()) {
            case "male":
                return MALE;
            case "female":
                return FEMALE;
            case "other":
                return OTHER;
            default:
                return UNKNOWN;
        }
    }
}

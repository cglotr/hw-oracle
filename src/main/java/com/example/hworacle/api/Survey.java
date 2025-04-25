package com.example.hworacle.api;

import com.example.hworacle.surveyingestion.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class Survey {
    @JsonProperty("age")
    private Integer age;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("region")
    private String region;

    @JsonProperty("surveyID")
    private String surveyId;

    @JsonProperty("score")
    private Integer score;

    public List<String> errors() {
        final List<String> errors = new ArrayList<>();

        if (getAge() == null) {
            errors.add("Missing field: 'age'");
        } else if (getAge() < 0) {
            errors.add("Invalid 'age': " + getAge());
        }

        if (getGender() == null) {
            errors.add("Missing field: 'gender'");
        } else if (Gender.from(getGender()).equals(Gender.UNKNOWN)) {
            errors.add("Unknown 'gender', please enter either 'male', 'female', or 'other': " + getGender());
        }

        if (getRegion() == null) {
            errors.add("Missing field: 'region'");
        }
        if (getSurveyId() == null) {
            errors.add("Missing field: 'surveyID'");
        }

        if (getScore() == null) {
            errors.add("Missing field: 'score'");
        } else if (getScore() < 1 || getScore() > 5) {
            errors.add("Score must be between [1, 5]. Score given is invalid: " + getScore());
        }

        return errors;
    }
}

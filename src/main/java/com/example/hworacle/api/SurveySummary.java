package com.example.hworacle.api;

import com.example.hworacle.surveyingestion.GenderSummary;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurveySummary {
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("score_avg")
    private double scoreAvg;

    @JsonProperty("survey_count")
    private long surveyCount;

    public SurveySummary(final GenderSummary genderSummary) {
        this.gender = genderSummary.getGender().toString();
        this.scoreAvg = genderSummary.getScoreAvg();
        this.surveyCount = genderSummary.getSurveyCount();
    }
}

package com.example.hworacle.surveyingestion;

import com.example.hworacle.api.Survey;
import lombok.Getter;

@Getter
public class SurveyData {
    private final int age;
    private final Gender gender;
    private final String region;
    private final String surveyId;
    private final int score;

    public SurveyData(final Survey survey) {
        this.age = survey.getAge();
        this.gender = Gender.from(survey.getGender());
        this.region = survey.getRegion();
        this.surveyId = survey.getSurveyId();
        this.score = survey.getScore();
    }
}

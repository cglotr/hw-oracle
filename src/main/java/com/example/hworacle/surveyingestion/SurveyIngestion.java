package com.example.hworacle.surveyingestion;

public interface SurveyIngestion {
    void ingest(final SurveyData surveyData);

    GenderSummary getGenderSummary(final Gender gender);
}

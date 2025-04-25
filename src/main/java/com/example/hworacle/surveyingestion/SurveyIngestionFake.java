package com.example.hworacle.surveyingestion;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class SurveyIngestionFake implements SurveyIngestion {
    private final Map<Gender, SurveyAgg> surveyAgg = new HashMap<>();

    public SurveyIngestionFake() {
        for (final Gender gender : Gender.values()) {
            surveyAgg.put(gender, new SurveyAgg());
        }
    }

    @Override
    public void ingest(final SurveyData surveyData) {
        surveyAgg.get(surveyData.getGender()).add(surveyData.getScore());
    }

    @Override
    public GenderSummary getGenderSummary(final Gender gender) {
        final SurveyAgg agg = surveyAgg.get(gender);
        return new GenderSummary(
            gender,
            agg.getAvgScore(),
            agg.getCount()
        );
    }

    @Getter
    public class SurveyAgg {
        private long score = 0;
        private long count = 0;

        public void add(final int score) {
            this.score += score;
            this.count += 1;
        }

        public double getAvgScore() {
            if (count < 1) {
                return 0d;
            }
            return (double) score / count;
        }
    }
}

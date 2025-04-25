package com.example.hworacle.surveyingestion;

import lombok.Data;

@Data
public class GenderSummary {
    private final Gender gender;
    private final double scoreAvg;
    private final long surveyCount;
}

package com.example.hworacle.resources;

import com.example.hworacle.api.Survey;
import com.example.hworacle.surveyingestion.SurveyIngestionFake;
import jakarta.ws.rs.BadRequestException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SurveysResourceTest {
    private SurveysResource surveysResource;

    @BeforeEach
    public void beforeEach() {
        surveysResource = new SurveysResource(new SurveyIngestionFake());
    }

    @Test
    public void dummy() {
        Assert.assertThrows(BadRequestException.class, () -> {
            surveysResource.post(new Survey());
        });
    }
}

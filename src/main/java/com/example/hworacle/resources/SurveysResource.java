package com.example.hworacle.resources;

import com.example.hworacle.api.Survey;
import com.example.hworacle.api.SurveySummary;
import com.example.hworacle.surveyingestion.Gender;
import com.example.hworacle.surveyingestion.GenderSummary;
import com.example.hworacle.surveyingestion.SurveyData;
import com.example.hworacle.surveyingestion.SurveyIngestion;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Path("/surveys")
@Produces(MediaType.APPLICATION_JSON)
public class SurveysResource {
    private static final Logger LOG = LoggerFactory.getLogger(SurveysResource.class);

    private final SurveyIngestion surveyIngestion;

    public SurveysResource(final SurveyIngestion surveyIngestion) {
        this.surveyIngestion = surveyIngestion;
    }

    @POST
    public Survey post(final Survey survey) {
        LOG.info("Ingesting survey: {}", survey);
        if (!survey.errors().isEmpty()) {
            final String errors = StringUtils.join(survey.errors(), ", ");
            final String errMsg = String.format("Survey contains validation errors: [%s]", errors);
            throw new BadRequestException(errMsg);
        }
        this.surveyIngestion.ingest(new SurveyData(survey));
        return survey;
    }

    @GET
    public List<SurveySummary> get() {
        final List<SurveySummary> surveySummaries = new ArrayList<>();
        for (final Gender gender : Gender.values()) {
            final GenderSummary genderSummary = surveyIngestion.getGenderSummary(gender);

            surveySummaries.add(new SurveySummary(genderSummary));
        }
        return surveySummaries;
    }
}

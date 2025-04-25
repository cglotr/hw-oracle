package com.example.hworacle;

import com.example.hworacle.surveyingestion.SurveyIngestion;
import com.example.hworacle.surveyingestion.SurveyIngestionFake;
import com.example.hworacle.resources.SurveysResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class HwOracleApplication extends Application<HwOracleConfiguration> {
    public static void main(String[] args) throws Exception {
        new HwOracleApplication().run(args);
    }

    @Override
    public String getName() {
        return "hw-oracle";
    }

    @Override
    public void initialize(Bootstrap<HwOracleConfiguration> bootstrap) {
    }

    @Override
    public void run(HwOracleConfiguration configuration, Environment environment) {
        final SurveyIngestion surveyIngestion = new SurveyIngestionFake();
        environment.jersey().register(new SurveysResource(surveyIngestion));
    }
}

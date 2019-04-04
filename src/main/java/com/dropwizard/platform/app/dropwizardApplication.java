package com.dropwizard.platform.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.dropwizard.platform.app.resources.controller;

public class dropwizardApplication extends Application<dropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizard";
    }

    @Override
    public void initialize(final Bootstrap<dropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final dropwizardConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    	environment.jersey().register(new controller());
    }

}

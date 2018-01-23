package org.verapdf.converter;

import com.codahale.metrics.health.HealthCheck;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ConverterWebApplication extends Application<ConverterConfiguration> {
    private static final Logger logger = LoggerFactory.getLogger(ConverterWebApplication.class);

    public static void main(String[] args) throws Exception {
        new ConverterWebApplication().run(args);
    }

    @Override
    public String getName() {
        return "Converter";
    }

    @Override
    public void initialize(Bootstrap<ConverterConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/html", "/", "home.jsp"));
    }

    @Override
    public void run(ConverterConfiguration configuration, Environment environment) {
        environment.jersey().setUrlPattern("/api/*");
        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            ResourceManager resourceManager = new ResourceManager(configuration);
            for (Object resource : resourceManager.getResources()) {
                environment.jersey().register(resource);
            }
            for (Map.Entry<String, HealthCheck> healthCheckEntry : resourceManager.getHealthChecks().entrySet()) {
                environment.healthChecks().register(healthCheckEntry.getKey(), healthCheckEntry.getValue());
            }

            logger.info("Converter web application started");
        } catch (Exception e) {
            logger.error("Error on converter web application startup", e);
            e.printStackTrace();
        }
    }
}
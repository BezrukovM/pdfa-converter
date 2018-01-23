package org.verapdf.converter;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.jetty.HttpConnectorFactory;
import io.dropwizard.server.DefaultServerFactory;

import java.util.*;

public class ResourceManager {

    private static final String NAME_CLEANER_SERVICE = "cleanerService";

    private final List<Object> resources = new ArrayList<>();
//    private final HashMap<String, AbstractService> services = new HashMap<>();
    private final Map<String, HealthCheck> healthChecks = new HashMap<>();

    private final ConverterConfiguration config;

    public ResourceManager(ConverterConfiguration config) {
        this.config = config;

        // Initializing resources
//        resources.add(new ReportResource(this));

//        for (Map.Entry<String, AbstractService> serviceEntry : this.services.entrySet()) {
//            healthChecks.put(serviceEntry.getKey(), new ServiceHealthCheck(serviceEntry.getValue()));
//        }

//        // Launching services
//        for (AbstractService service : this.services.values()) {
//            service.start();
//        }
    }

    public Map<String, HealthCheck> getHealthChecks() {
        return Collections.unmodifiableMap(this.healthChecks);
    }

    public List<Object> getResources() {
        return Collections.unmodifiableList(this.resources);
    }
}

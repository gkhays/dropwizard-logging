package io.github.dropwizard;

import io.github.dropwizard.health.SimpleHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class LoggingTestApplication extends Application<LoggingTestConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LoggingTestApplication().run(args);
    }

    @Override
    public String getName() {
        return "LoggingTest";
    }

    @Override
    public void initialize(final Bootstrap<LoggingTestConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final LoggingTestConfiguration configuration,
                    final Environment environment) {
        LockFileManager manager = new LockFileManager(configuration.getPath());
        environment.lifecycle().manage(manager);
        final SimpleHealthCheck healthCheck = new SimpleHealthCheck();
        environment.healthChecks().register(getName(), healthCheck);
    }

}

package io.github.dropwizard.health;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codahale.metrics.health.HealthCheck;

public class SimpleHealthCheck extends HealthCheck {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleHealthCheck.class);

    @Override
    protected Result check() throws Exception {
        final Path path = FileSystems.getDefault().getPath(".");
        LOGGER.info("The path is: {}", path);

        LOGGER.info("Reporting unhealthy");
        return Result.unhealthy("Help me!");
    }

}

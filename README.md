# Dropwizard Logging Test

```java
io.dropwizard.configuration.ConfigurationValidationException: config.yml has an error:
  * when specifying maxFileSize, archivedLogFilenamePattern must contain %i

        at io.dropwizard.configuration.BaseConfigurationFactory.validate(BaseConfigurationFactory.java:246)
        at io.dropwizard.configuration.BaseConfigurationFactory.build(BaseConfigurationFactory.java:129)
        at io.dropwizard.configuration.BaseConfigurationFactory.build(BaseConfigurationFactory.java:90)
        at io.dropwizard.cli.ConfiguredCommand.parseConfiguration(ConfiguredCommand.java:137)
        at io.dropwizard.cli.ConfiguredCommand.run(ConfiguredCommand.java:85)
        at io.dropwizard.cli.Cli.run(Cli.java:78)
        at io.dropwizard.Application.run(Application.java:94)
        at com.netiq.dropwizard.LoggingTestApplication.main(LoggingTestApplication.java:10)
```

## Quick Start

On first start, this project will detect the log files and trigger the roll-over. On subsequent runs, write a file called `myFile.txt` to the root directory of this project.

How to start the LoggingTest application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-logging-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

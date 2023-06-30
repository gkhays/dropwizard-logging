package io.github.dropwizard;

import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class LoggingTestConfiguration extends Configuration {
    
    @NotEmpty
    private String path;

    @JsonProperty
    public String getPath() {
        return path;
    }

    @JsonProperty
    public void setPath(String s) {
        this.path = s;
    }

}

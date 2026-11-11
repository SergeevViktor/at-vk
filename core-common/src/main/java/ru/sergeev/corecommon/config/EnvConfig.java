package ru.sergeev.corecommon.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "context")
public class EnvConfig {
    private String baseUrl;
    private String baseUiUrl;
    private WebDriverType webDriverType;

    public enum WebDriverType {
        CHROME,
        EDGE
    }
}

package ru.sergeev.corecommon;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import ru.sergeev.corecommon.config.EnvConfig;

import java.util.Arrays;

@Configuration
@EnableConfigurationProperties(EnvConfig.class)
@ComponentScan
@Slf4j
public class BaseContextConfiguration {
    @Autowired
    private EnvConfig context;
    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        log.info("Spring profile: {}", Arrays.toString(env.getActiveProfiles()));
        log.info("Context params: {}", context);
    }
}

package ru.svistunovdv.loggingstarter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import ru.svistunovdv.loggingstarter.aspect.LogExecutionAspect;
import ru.svistunovdv.loggingstarter.property.ConfigurationProperties;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingFilter;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingRequestBodyAdvice;

@AutoConfiguration
@ComponentScan
@ConditionalOnProperty(prefix = "logging", value = "enabled", havingValue = "true", matchIfMissing = true)
public class LoggingStarterAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "logging", value = "log-exec-time", havingValue = "true")
    public LogExecutionAspect logExecutionAspect() {
        return new LogExecutionAspect();
    }

    @Bean
    @ConditionalOnProperty(prefix = "logging.web-logging", value = "enabled", havingValue = "true", matchIfMissing = true)
    public WebLoggingFilter webLoggingFilter(ConfigurationProperties properties) {
        return new WebLoggingFilter(properties);
    }

    @Bean
    @ConditionalOnProperty(prefix = "logging.web-logging", value = {"enabled", "log-body"}, havingValue = "true")
    public WebLoggingRequestBodyAdvice webLoggingRequestBodyAdvice() {
        return new WebLoggingRequestBodyAdvice();
    }
}
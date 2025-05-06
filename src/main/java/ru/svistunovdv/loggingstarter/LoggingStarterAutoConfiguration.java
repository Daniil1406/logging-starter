package ru.svistunovdv.loggingstarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import ru.svistunovdv.loggingstarter.aspect.LogExecutionAspect;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingFilter;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingRequestBodyAdvice;

import java.util.List;

@AutoConfiguration
@PropertySource("classpath:application.properties")
@ConditionalOnProperty(prefix = "logging", value = "enabled", havingValue = "true", matchIfMissing = true)
public class LoggingStarterAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "logging", value = "log-exec-time", havingValue = "true")
    public LogExecutionAspect logExecutionAspect() {
        return new LogExecutionAspect();
    }

    @Bean
    @ConditionalOnProperty(prefix = "logging.web-logging", value = "enabled", havingValue = "true", matchIfMissing = true)
    public WebLoggingFilter webLoggingFilter(@Value("${logging-starter.headers.keys}") List<String> headers) {
        return new WebLoggingFilter(headers);
    }

    @Bean
    @ConditionalOnProperty(prefix = "logging.web-logging", value = {"enabled", "log-body"}, havingValue = "true")
    public WebLoggingRequestBodyAdvice webLoggingRequestBodyAdvice() {
        return new WebLoggingRequestBodyAdvice();
    }
}
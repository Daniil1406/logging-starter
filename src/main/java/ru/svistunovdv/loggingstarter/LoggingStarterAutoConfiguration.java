package ru.svistunovdv.loggingstarter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import ru.svistunovdv.loggingstarter.aspect.LogExecutionAspect;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingFilter;
import ru.svistunovdv.loggingstarter.webfilter.WebLoggingRequestBodyAdvice;

@AutoConfiguration
public class LoggingStarterAutoConfiguration {

    @Bean
    public LogExecutionAspect logExecutionAspect(){
        return new LogExecutionAspect();
    }

    @Bean
    public WebLoggingFilter webLoggingFilter(){
        return new WebLoggingFilter();
    }

    @Bean
    public WebLoggingRequestBodyAdvice webLoggingRequestBodyAdvice(){
        return new WebLoggingRequestBodyAdvice();
    }


}
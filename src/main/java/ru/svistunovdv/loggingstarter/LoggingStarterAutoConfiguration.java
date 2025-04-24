package ru.svistunovdv.loggingstarter;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import ru.svistunovdv.loggingstarter.aspect.LogExecutionAspect;

@AutoConfiguration
public class LoggingStarterAutoConfiguration {

    @Bean
    public LogExecutionAspect logExecutionAspect(){
        return new LogExecutionAspect();
    };
}
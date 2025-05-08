package ru.svistunovdv.loggingstarter.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigurationProperties {

    @Value("${logging-starter.headers.keys}")
    private List<String> requestHeadersKeys;

    public List<String> getRequestHeadersKeys() {
        return requestHeadersKeys;
    }

    public void setRequestHeadersKeys(List<String> requestHeadersKeys) {
        this.requestHeadersKeys = requestHeadersKeys;
    }
}

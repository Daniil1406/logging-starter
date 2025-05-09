package ru.svistunovdv.loggingstarter.property;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.boot.context.properties.ConfigurationProperties("logging-starter")
public class ConfigurationProperties {
    
    private List<String> maskingHeaders = List.of();

    public List<String> getMaskingHeaders() {
        return maskingHeaders;
    }

    public void setMaskingHeaders(List<String> maskingHeaders) {
        this.maskingHeaders = maskingHeaders;
    }
}

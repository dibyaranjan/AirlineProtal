package com.github.dibyaranjan.airlineportal.framework.rest.comsumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("restEndpointConfiguration.properties")
public class EndpointCommonConfiguration {
    @Value("${auth-key}")
    private String authorizationKey;

    public String getAuthorizationKey() {
        return authorizationKey;
    }
}

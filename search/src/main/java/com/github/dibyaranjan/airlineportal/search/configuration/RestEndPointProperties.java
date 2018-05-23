package com.github.dibyaranjan.airlineportal.search.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("restEndpoints.properties")
public class RestEndPointProperties {
    @Value("${all-city-api}")
    private String allCityApi;

    @Value("${auth-key}")
    private String authrizationKey;

    @Value("${search-api-endpoint}")
    private String searchApiEndpoint;

    public String getAllCityApi() {
        return allCityApi;
    }

    public String getAuthrizationKey() {
        return authrizationKey;
    }

    public String getSearchApiEndpoint() {
        return searchApiEndpoint;
    }
}

package com.github.dibyaranjan.airlineportal.framework.rest.comsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConsumer<T> {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EndpointCommonConfiguration endpointCommonConfiguration;

    public T getObject(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", endpointCommonConfiguration.getAuthorizationKey());
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, request, responseType);
        return response.getBody();
    }
}

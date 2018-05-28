package com.github.dibyaranjan.airlineportal.search.controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.EndpointCommonConfiguration;
import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.RestConsumer;
import com.github.dibyaranjan.airlineportal.search.configuration.RestEndPointProperties;
import com.github.dibyaranjan.airlineportal.search.consumer.LowFareSearchResultProcessor;
import com.github.dibyaranjan.airlineportal.search.controller.FlightProposalController;
import com.github.dibyaranjan.airlineportal.search.service.LowFareSearchService;
import com.github.dibyaranjan.airlineportal.validator.FlightProposalRequestValidator;
import com.github.dibyaranjan.airlineportal.validator.StringValidator;
import com.github.dibyaranjan.infra.converter.BaseConverter;

/**
 * 
 * 
 * @author dranjan
 */
@Configuration
@ComponentScan(basePackageClasses = { EndpointCommonConfiguration.class, RestConsumer.class, RestTemplate.class,
        LowFareSearchService.class, RestEndPointProperties.class, LowFareSearchResultProcessor.class,
        FlightProposalController.class, FlightProposalRequestValidator.class, StringValidator.class })
public class LowFareSearchServiceITConfiguration {
    @Bean
    public BaseConverter baseConverter() {
        return new BaseConverter("com.github.dibyaranjan.airlineportal");
    }
}

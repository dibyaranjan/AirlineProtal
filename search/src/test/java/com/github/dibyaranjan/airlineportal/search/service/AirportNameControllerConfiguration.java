package com.github.dibyaranjan.airlineportal.search.service;

import com.github.dibyaranjan.airlineportal.cache.AirportCache;
import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.RestConsumer;
import com.github.dibyaranjan.airlineportal.modelobjects.json.model.AirportJson;
import com.github.dibyaranjan.airlineportal.search.configuration.RestEndPointProperties;
import com.github.dibyaranjan.airlineportal.search.controller.AirportNameController;
import com.github.dibyaranjan.airlineportal.search.modelobject.Cities;
import com.github.dibyaranjan.infra.converter.BaseConverter;
import com.github.dibyaranjan.infra.converter.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackageClasses = {AirportNameController.class, AirportDetailsFetcher.class,
        RestEndPointProperties.class, RestConsumer.class})
public class AirportNameControllerConfiguration {

    @Bean(name = "airportCache")
    public AirportCache airportCache(RestEndPointProperties endPointProperties, RestConsumer<Cities> citiesConsumer,
                                     RestConsumer<AirportJson> airportConsumer) {
        AirportCacheBackedByMap cache = new AirportCacheBackedByMap();
        cache.setAirportConsumer(airportConsumer);
        cache.setCitiesConsumer(citiesConsumer);
        cache.setConverter(converter());
        cache.setEndPointProperties(endPointProperties);
        cache.loadCache();
        return cache;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Converter converter() {
        BaseConverter baseConverter = new BaseConverter("com.github");
        return baseConverter;
    }
}

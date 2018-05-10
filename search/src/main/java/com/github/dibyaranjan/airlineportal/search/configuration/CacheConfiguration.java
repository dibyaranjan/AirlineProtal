package com.github.dibyaranjan.airlineportal.search.configuration;

import com.github.dibyaranjan.airlineportal.cache.AirportCache;
import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.RestConsumer;
import com.github.dibyaranjan.airlineportal.modelobjects.json.model.AirportJson;
import com.github.dibyaranjan.airlineportal.search.modelobject.Cities;
import com.github.dibyaranjan.airlineportal.search.service.AirportCacheBackedByMap;
import com.github.dibyaranjan.infra.converter.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CacheConfiguration {

    @Bean(name = "airportCache")
    public AirportCache airportCache(RestTemplate restTemplate, RestEndPointProperties endPointProperties,
            RestConsumer<Cities> citiesConsumer, RestConsumer<AirportJson> airportConsumer, Converter converter) {
        AirportCacheBackedByMap cache = new AirportCacheBackedByMap();
        cache.setAirportConsumer(airportConsumer);
        cache.setCitiesConsumer(citiesConsumer);
        cache.setConverter(converter);
        cache.setEndPointProperties(endPointProperties);
        cache.loadCache();
        return cache;
    }
}

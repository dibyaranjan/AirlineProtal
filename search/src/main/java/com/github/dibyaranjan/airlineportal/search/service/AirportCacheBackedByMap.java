package com.github.dibyaranjan.airlineportal.search.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.github.dibyaranjan.airlineportal.cache.AirportCache;
import com.github.dibyaranjan.airlineportal.framework.rest.comsumer.RestConsumer;
import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.airlineportal.modelobjects.city.City;
import com.github.dibyaranjan.airlineportal.modelobjects.json.model.AirportJson;
import com.github.dibyaranjan.airlineportal.search.configuration.RestEndPointProperties;
import com.github.dibyaranjan.airlineportal.search.modelobject.AirportLink;
import com.github.dibyaranjan.airlineportal.search.modelobject.Cities;
import com.github.dibyaranjan.airlineportal.search.modelobject.CityJson;
import com.github.dibyaranjan.infra.converter.Converter;


public class AirportCacheBackedByMap implements AirportCache {
    private static Map<String, Airport> cache = new TreeMap<>();
    private static Map<String, List<Airport>> cityCache = new TreeMap<>();

    private RestEndPointProperties endPointProperties;
    private RestConsumer<Cities> citiesConsumer;
    private RestConsumer<AirportJson> airportConsumer;
    private Converter converter;

    public void setEndPointProperties(RestEndPointProperties endPointProperties) {
        this.endPointProperties = endPointProperties;
    }

    public void setCitiesConsumer(RestConsumer<Cities> citiesConsumer) {
        this.citiesConsumer = citiesConsumer;
    }

    public void setAirportConsumer(RestConsumer<AirportJson> airportConsumer) {
        this.airportConsumer = airportConsumer;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    @Override
    public List<Airport> getAllAirports() {
        return new ArrayList<>(cache.values());
    }

    @Override
    public Airport getAirport(String airportName) {
        return cache.get(airportName);
    }

    @Override
    public List<Airport> getAirportByCityName(String cityName) {
        return cityCache.get(cityName);
    }

    @Override
    public void loadCache() {
        Cities supportedCities = citiesConsumer.getObject(endPointProperties.getAllCityApi(), Cities.class);
        List<CityJson> cities = supportedCities.getCities();

        long x = System.currentTimeMillis();
        cities.parallelStream().forEach(cityJson -> {
            List<Airport> airportsForCity = new ArrayList<>();
            List<AirportLink> airportLinks = cityJson.getAirportLinks();
            airportLinks.forEach(airportLink -> {
                String url = airportLink.getHref();
                AirportJson airport = airportConsumer.getObject(url, AirportJson.class);
                List<com.github.dibyaranjan.airlineportal.modelobjects.json.model.Airport> airportsFromJson = airport.getAirports();
                airportsFromJson.parallelStream().forEach(airportJson -> {
                    City cityVo = converter.convert(new City(), cityJson);

                    Airport airportVo = converter.convert(new Airport(), airportJson);
                    airportVo.setCity(cityVo);
                    cache.put(airportVo.getCode().toUpperCase(), airportVo);
                    airportsForCity.add(airportVo);
                });
            });
            cityCache.put(cityJson.getName(), airportsForCity);
        });

        System.out.println((System.currentTimeMillis() - x) / 1000F);
    }
}
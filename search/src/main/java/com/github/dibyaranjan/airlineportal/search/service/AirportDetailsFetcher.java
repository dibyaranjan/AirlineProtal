package com.github.dibyaranjan.airlineportal.search.service;

import com.github.dibyaranjan.airlineportal.cache.AirportCache;
import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AirportDetailsFetcher {
    @Autowired
    @Qualifier("airportCache")
    private AirportCache cache;

    public List<Airport> getAllAirports() {
        return cache.getAllAirports();
    }

    public Airport getAirport(String iataCode) {
        return cache.getAirport(iataCode);
    }

    public List<Airport> getAirportByFreeText(String string) {
        Airport airportByIataCode = getAirport(string);
        if (airportByIataCode != null) {
            return Arrays.asList(airportByIataCode);
        }

        List<Airport> airportsContainingFreeText = new ArrayList<>();
        List<Airport> allAirports = cache.getAllAirports();
        allAirports.parallelStream().forEach(airport -> {
            if (airport.getCity().getName().contains(string)) {
                airportsContainingFreeText.add(airport);
            }
        });

        return airportsContainingFreeText;
    }
}

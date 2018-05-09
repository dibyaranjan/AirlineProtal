package com.github.dibyaranjan.airlineportal.cache;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;

import java.util.List;

public interface AirportCache extends Cache {
    List<Airport> getAllAirports();

    Airport getAirport(String airportName);

    List<Airport> getAirportByCityName(String cityName);
}

package com.github.dibyaranjan.airlineportal.cache;

import java.util.List;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;

public interface AirportCache extends Cache {
    List<Airport> getAllAirports();

    Airport getAirport(String airportName);

    List<Airport> getAirportByCityName(String cityName);
}

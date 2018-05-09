package com.github.dibyaranjan.airlineportal.search.controller;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.airlineportal.modelobjects.json.wrapper.impl.AirportList;
import com.github.dibyaranjan.airlineportal.search.modelobject.Cities;
import com.github.dibyaranjan.airlineportal.search.service.AirportDetailsFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class AirportNameController {

    @Autowired
    private AirportDetailsFetcher airportDetailsFetcher;

    @RequestMapping("/")
    public AirportList getAllAirports() {
        airportDetailsFetcher.getAllAirports();
        return new AirportList();
    }

    @RequestMapping("/cities")
    public Cities getAllCities() {
        return null;
    }

    @RequestMapping("/airports/{airportName}")
    public Airport getAirports(@PathVariable("airportName") String airportName) {
        return airportDetailsFetcher.getAirport(airportName);
    }

    @RequestMapping("/airports/{city}")
    public List<Airport> getAirportsByCity(@PathVariable("city") String city) {
        return airportDetailsFetcher.getAirportByFreeText(city);
    }
}

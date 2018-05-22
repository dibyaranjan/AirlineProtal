package com.github.dibyaranjan.airlineportal.search.controller;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.airlineportal.search.service.AirportDetailsFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
@CrossOrigin(origins = "http://localhost:8081")
public class AirportNameController {
    @Autowired
    private AirportDetailsFetcher airportDetailsFetcher;
    
    @RequestMapping(value = "/")
    public List<Airport> getAllAirports() {
        return airportDetailsFetcher.getAllAirports();
    }
    
    public List<Airport> getAirportByFreeText(String freeText) {
        return airportDetailsFetcher.getAirportByFreeText(freeText);
    }
    
    @RequestMapping(value = "/{airportName}")
    public Airport getAirports(@PathVariable("airportName") String airportName) {
        return airportDetailsFetcher.getAirport(airportName);
    }
}

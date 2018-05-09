package com.github.dibyaranjan.airlineportal.search.service;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.airlineportal.modelobjects.city.City;
import com.github.dibyaranjan.airlineportal.search.controller.AirportNameController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AirportNameControllerConfiguration.class})
public class AirportNameControllerIT {
    @Autowired
    private AirportNameController controller;

    @Test
    public void testControllerWithAirportCode() {
        Airport actualAirport = controller.getAirports("DXB");
        Airport expectedAirport = new Airport();
        expectedAirport.setCode("DXB");
        expectedAirport.setName("Dubai International Airport");
        Assert.assertEquals("Expected airport should be equals to actual airport", expectedAirport, actualAirport);
    }

    @Test
    public void testControllerWithFreeText() {
        List<Airport> actualAirport = controller.getAirportsByCity("Dubai");
        Airport expectedAirport = new Airport();
        expectedAirport.setCode("DXB");
        expectedAirport.setName("Dubai International Airport");
        City city = new City();
        city.setCode("DXB");
        expectedAirport.setCity(city);
        expectedAirport.setName("Dubai");
        Assert.assertTrue("Expected airport should be equals to actual airport", actualAirport.contains
                (expectedAirport));
    }
}

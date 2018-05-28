package com.github.dibyaranjan.airlineportal.search.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.airlineportal.modelobjects.city.City;
import com.github.dibyaranjan.airlineportal.search.controller.config.AirportNameControllerConfiguration;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { AirportNameControllerConfiguration.class })
public class AirportNameControllerIT {
	@Autowired
	private AirportNameController controller;
	private Airport expectedAirport;

	@Before
	public void setUp() {
		City expectedCity = new City();
		expectedCity.setCode("DXB");
		expectedCity.setName("Dubai");

		expectedAirport = new Airport();
		expectedAirport.setCode("DXB");
		expectedAirport.setName("Dubai International Airport");
		expectedAirport.setCity(expectedCity);
	}

	@Test
	public void testControllerWithAirportCode() {
		Airport actualAirport = controller.getAirports("DXB");

		Assert.assertEquals(
				"Expected airport should be equals to actual airport",
				expectedAirport, actualAirport);
	}

	@Test
	public void testControllerWithFreeText() {
		List<Airport> actualAirport = controller.getAirportByFreeText("Dubai");
			
		Assert.assertTrue(
				"Expected airport should be equals to actual airport",
				actualAirport.contains(expectedAirport));
	}
}

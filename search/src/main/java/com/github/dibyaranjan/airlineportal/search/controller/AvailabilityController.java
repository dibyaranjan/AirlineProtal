package com.github.dibyaranjan.airlineportal.search.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dibya Ranjan
 */
@RestController
@RequestMapping("/availability")
@CrossOrigin(origins = "http://localhost:8081")
public class AvailabilityController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAvailability() {
        System.out.println("called availability");
        return "not implemented";
    }
}

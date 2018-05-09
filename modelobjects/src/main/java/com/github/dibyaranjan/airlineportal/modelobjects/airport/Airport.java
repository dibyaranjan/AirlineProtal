package com.github.dibyaranjan.airlineportal.modelobjects.airport;

import com.github.dibyaranjan.airlineportal.modelobjects.city.City;

import java.util.Objects;

public class Airport {
    private String code;
    private String name;

    private City city;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(code, airport.code) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(city, airport.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, city);
    }
}

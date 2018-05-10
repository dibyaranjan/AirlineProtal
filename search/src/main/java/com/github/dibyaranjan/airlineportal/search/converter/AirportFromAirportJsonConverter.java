package com.github.dibyaranjan.airlineportal.search.converter;

import com.github.dibyaranjan.airlineportal.modelobjects.airport.Airport;
import com.github.dibyaranjan.infra.converter.SimpleObjectConverter;
import com.github.dibyaranjan.infra.converter.annotation.Convert;

@Convert(source = com.github.dibyaranjan.airlineportal.modelobjects.json.model.Airport.class, target = Airport.class)
public class AirportFromAirportJsonConverter extends SimpleObjectConverter {

    @SuppressWarnings("unchecked")
    @Override
    protected <T, S> T doConvert(T targetObject, S sourceObject) {
        com.github.dibyaranjan.airlineportal.modelobjects.json.model.Airport source = (com.github.dibyaranjan.airlineportal.modelobjects
                .json.model.Airport) sourceObject;
        Airport airport = (Airport) targetObject;
        airport.setCode(source.getIataCode());
        airport.setName(source.getName());

        return (T) airport;
    }
}

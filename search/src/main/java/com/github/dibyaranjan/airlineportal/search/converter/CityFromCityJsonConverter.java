package com.github.dibyaranjan.airlineportal.search.converter;

import com.github.dibyaranjan.airlineportal.modelobjects.city.City;
import com.github.dibyaranjan.airlineportal.search.modelobject.CityJson;
import com.github.dibyaranjan.infra.converter.SimpleObjectConverter;
import com.github.dibyaranjan.infra.converter.annotation.Convert;

@Convert(target = City.class, source = CityJson.class)
public class CityFromCityJsonConverter extends SimpleObjectConverter {
    @SuppressWarnings("unchecked")
    @Override
    protected <T, S> T doConvert(T targetObject, S sourceObject) {
        CityJson source = (CityJson) sourceObject;
        City city = (City) targetObject;
        city.setName(source.getName());
        city.setCode(source.getCode());
        return (T)city;
    }
}

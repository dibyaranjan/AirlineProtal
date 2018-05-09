package com.github.dibyaranjan.airlineportal.search.converter;

import com.github.dibyaranjan.airlineportal.modelobjects.city.City;
import com.github.dibyaranjan.airlineportal.search.modelobject.CityJson;
import com.github.dibyaranjan.infra.converter.AbstractConverter;
import com.github.dibyaranjan.infra.converter.annotation.Convert;

@Convert(target = City.class, source = CityJson.class)
public class CityFromCityJsonConverter extends AbstractConverter{
    @Override
    protected <T, S> T doConvert(S sourceObject) {
        CityJson source = (CityJson) sourceObject;
        City city = new City();
        city.setName(source.getName());
        city.setCode(source.getCode());
        return (T)city;
    }
}

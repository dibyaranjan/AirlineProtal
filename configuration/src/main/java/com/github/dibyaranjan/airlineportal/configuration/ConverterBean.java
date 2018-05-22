package com.github.dibyaranjan.airlineportal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.github.dibyaranjan.infra.converter.BaseConverter;
import com.github.dibyaranjan.infra.converter.Converter;

@Component
public class ConverterBean {
    @Bean
    public Converter baseConverter() {
        return new BaseConverter("com.github.dibyaranjan.airlineportal");
    }
}
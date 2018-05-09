package com.github.dibyaranjan.airlineportal.configuration;

import com.github.dibyaranjan.infra.converter.BaseConverter;
import com.github.dibyaranjan.infra.converter.Converter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConverterBean {
    @Bean
    public Converter baseConverter() {
        return new BaseConverter("com.github.dibyaranjan.airlineportal");
    }
}

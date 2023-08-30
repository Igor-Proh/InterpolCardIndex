package com.prokhnov.interpolCardIndex.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * The {@code AppConfiguration} class.<br/>
 * Application configuration class
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@Configuration
public class AppConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

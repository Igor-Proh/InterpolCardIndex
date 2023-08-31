package com.prokhnov.interpolCardIndex;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The {@code InterpolCardIndexApplication} class.<br/>
 * Start point of application
 *
 * @author Ihor Prokhnov
 * @version 1.0 Aug 2023
 */
@SpringBootApplication()
@EnableWebMvc
@EntityScan("com.prokhnov.interpolCardIndex.model")
@EnableJpaRepositories("com.prokhnov.interpolCardIndex.repository")
public class InterpolCardIndexApplication {
    public static void main(String[] args) {
        SpringApplication.run(InterpolCardIndexApplication.class, args);
        BasicConfigurator.configure();
    }

}

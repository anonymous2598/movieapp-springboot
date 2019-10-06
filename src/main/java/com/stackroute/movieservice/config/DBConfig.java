package com.stackroute.movieservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration

public class DBConfig {

    @Bean
    @Profile("prod")
    public String sqlconnection()
    {
        return "sql";
    }

    @Bean
    @Profile("dev")
    public String h2connection()
    {
     return "h2";
    }
}

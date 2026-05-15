package com.dsi3.api_usuarios.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseConfig {

    @Bean
    JdbcTemplate configureDatabase(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
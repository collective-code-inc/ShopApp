package com.shop.login.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.PostgreSQLContainer;

@Configuration
public class TestAppConfig {

    private static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15-alpine");

            static {
                container.start();
            }
            
     @Bean
    DataSource dataSource() {
        return DataSourceBuilder.create()
        .url(container.getJdbcUrl())
        .username(container.getUsername())
        .password(container.getPassword())
        .build();
    }
                

    
}

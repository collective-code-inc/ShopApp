package com.shop.login.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

     @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .load();
        flyway.migrate();
        return flyway;
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:postgresql://shopappdb.cnku8eqawzpn.eu-north-1.rds.amazonaws.com:5432/postgres");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("Nortons12345");
        return dataSourceBuilder.build();
    }
    
}

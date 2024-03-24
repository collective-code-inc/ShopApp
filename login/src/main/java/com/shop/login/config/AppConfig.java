package com.shop.login.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Profile("prod")
    @Bean
    public DataSource getDataSourceProd() {
        return DataSourceBuilder.create()
        .url("jdbc:postgresql://shopappdb.cnku8eqawzpn.eu-north-1.rds.amazonaws.com:5432/postgres")
        .username("postgres")
        .password("Nortons12345")
        .build();
    }

    @Profile("local-ashu")
    @Bean
    public DataSource getDataSourceLocalAshu() {
        return DataSourceBuilder.create()
        .url("jdbc:postgresql://127.0.0.1:5433/shopapp")
        .username("postgres")
        .password("adept")
        .build();
    }

    @Profile("local-mohit")
    @Bean
    public DataSource getDataSourceLocalMohit() {
        return DataSourceBuilder.create()
        .url("jdbc:postgresql://127.0.0.1:5432/shop_app")
        .username("postgres")
        .password("password")
        .build();
    }
    
}

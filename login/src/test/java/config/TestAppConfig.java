package config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testcontainers.containers.PostgreSQLContainer;

import com.shop.login.config.AppConfig;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com")
public class TestAppConfig extends AppConfig {

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

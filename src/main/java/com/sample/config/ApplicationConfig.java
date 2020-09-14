package com.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfig {

    @Value("${database.url}")
    private String jdbcUrl;

    @Value("${database.username}")
    private String userName;

    @Value("${database.password}")
    private String password;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

package com.sample.config;

import com.zaxxer.hikari.HikariDataSource;

import java.util.Properties;

public class RdsHikariDataSource extends HikariDataSource {

    public RdsHikariDataSource(String jdbcUrl, String username, String password) {
        this.setJdbcUrl(jdbcUrl);
        this.setPoolName("RdsHikariDatasource");
        this.setRegisterMbeans(true);
        this.setConnectionTestQuery("SELECT 1");
        this.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        this.setMaximumPoolSize(5);
        Properties dsProperties = new Properties();
        dsProperties.setProperty("url", jdbcUrl);
        this.setDataSourceProperties(dsProperties);

        this.setUsername(username);
        this.setPassword(password);
    }
}

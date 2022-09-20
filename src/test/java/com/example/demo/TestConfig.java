package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class TestConfig {
    @Bean
    public static DataSource dataSourceTest(){
        DriverManagerDataSource dataSourceTest = new DriverManagerDataSource();
        dataSourceTest.setDriverClassName("org.h2.Driver");
        dataSourceTest.setUrl("jdbc:h2:mem:testdb");
        dataSourceTest.setPassword("");
        dataSourceTest.setUsername("sa");
        return dataSourceTest;
    }

}

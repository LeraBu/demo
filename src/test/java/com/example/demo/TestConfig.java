package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class TestConfig {

  /*  @Bean
    public static DataSource dataSourceTest(){
        DriverManagerDataSource dataSourceTest = new DriverManagerDataSource();
        dataSourceTest.setDriverClassName("org.h2.Driver");
        dataSourceTest.setUrl("jdbc:h2:mem:testdb");
        dataSourceTest.setPassword("");
        dataSourceTest.setUsername("sa");
        return dataSourceTest;
    }*/

    @Bean(name = "dataSourceTest")
    public DataSource dataSourceTest(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setName("H2-Test-DB");
        EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:db-script/ddl.sql")
                .addScript("classpath:db-script/dml.sql").build();
      //  log.info("Initiating the database from dbscript.");
        return db; }

    @Bean
    public JdbcTemplate jdbcTemplateTest(){
        return new JdbcTemplate(dataSourceTest());
    }

}



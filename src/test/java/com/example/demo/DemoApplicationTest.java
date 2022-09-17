package com.example.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTest {

  //  @Autowired
   // protected DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    private EmbeddedDatabase embeddedDatabase;
    @Before
    public void setUp() {
        // Создадим базу данных для тестирования
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .addDefaultScripts()
                .setType(EmbeddedDatabaseType.H2)
                .build();
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);
    }

    String routeTest = "NSNSNSNSNS";
    Route route = new Route(1, routeTest, Task.isItAGoodRoute(routeTest));


    @Test
    public void myTest() throws Exception {
        jdbcTemplate.update("INSERT INTO mythreetable VALUES(" + route.getId() + ", '" + route.getDescription() + "', '" + route.getGoodorbad() + "')");
    }
}
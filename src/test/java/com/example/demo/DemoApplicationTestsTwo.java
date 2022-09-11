package com.example.demo;


import org.h2.security.auth.H2AuthConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.annotation.PostConstruct;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
//@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@DataJpaTest
//@SpringBootApplication
public class DemoApplicationTestsTwo {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ControllerDemo controllerDemo;

    private EmbeddedDatabase embeddedDatabase;

    private JdbcTemplate jdbcTemplate;

   /* @Repository
    public interface RouteRepository
            extends CrudRepository<Route, Integer> {
    }*/

  //  private PersonRepository personRepository;

    @Before
    public void setUp() {
        // Создадим базу данных для тестирования
        embeddedDatabase = new EmbeddedDatabaseBuilder()
                .addDefaultScripts()// Добавляем скрипты schema.sql и data.sql
                .setType(EmbeddedDatabaseType.H2)// Используем базу H2
                .build();

        // Создадим JdbcTemplate
        jdbcTemplate = new JdbcTemplate(embeddedDatabase);

        // Создадим PersonRepository
        //  personRepository = new PersonRepositoryImpl(jdbcTemplate);

    }



    @Test
    public void dbTest() throws Exception {
        String routeTest = "NSNSNSNSNS";
        Route route = new Route(1, routeTest, Task.isItAGoodRoute(routeTest));
        MvcResult mvcResult = mockMvc.perform(get("/hello?newRoute={route}", routeTest))
                .andDo(print())
                .andExpect(content().string("This is a good route"))
                .andReturn();

      /*  DBObject objectToSave = BasicDBObjectBuilder.start()
                .add(route.getDescription(), route.getGoodorbad())
                .get(); */




     //   jdbcTemplate.update("create table routestest (id int(36) primary key, description varchar(255), goodorbad  varchar(255) not null unique");
      //  jdbcTemplate.execute("insert into routestest(description, goodorbad) values('" + route.getDescription() + "', '" + route.getGoodorbad() + "')");
      //  jdbcTemplate.execute("select * from routestest");

     //   jdbcTemplate.update("i")

                /* assertThat(mongoTemplate.findAll(DBObject.class, "collection"))
                .extracting(route.getDescription())
                .containsOnly(mvcResult.getResponse().getContentAsString()); */
    }

}



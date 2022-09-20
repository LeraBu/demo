package com.example.demo;

import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
class DemoApplicationTest {

    private static JdbcTemplate jdbcTemplateTest;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ControllerDemo controllerDemo;

    @Autowired
    public JdbcTemplate jdbcTemplateTest(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(TestConfig.dataSourceTest());
        return jdbcTemplate;
    }

    @Autowired
    public DemoApplicationTest(JdbcTemplate jdbcTemplateTest) {
        this.jdbcTemplateTest = jdbcTemplateTest;
    }

    @BeforeEach
    public void setUp() {
        jdbcTemplateTest.update("create table testTable (id int, description varchar, goodorbad varchar)");
        System.out.println("table created");
    }

    String routeTest = "NSNSNSNSNS";

    @Test
    public void myTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/hello?newRoute={route}", routeTest))
                .andDo(print())
                .andExpect(content().string("This is a good route"))
                .andReturn();

        String resultRoute = result.getResponse().getContentAsString();
        System.out.println("!!!!!!Content =" + resultRoute);
        Route routeRes = new Route(1, resultRoute, Task.isItAGoodRoute(resultRoute));
        jdbcTemplateTest.update("INSERT INTO testTable VALUES(" + routeRes.getId() + ", '" + routeRes.getDescription() + "', '" + routeRes.getGoodorbad() + "')");
        System.out.println(jdbcTemplateTest.query("SELECT * FROM testTable", new RouteMapper()));
      //  Route routeFromTable = jdbcTemplateTest.query("SELECT * FROM testTable WHERE ID = '1'", new RouteMapper());
        assertEquals(resultRoute, (jdbcTemplateTest.query("SELECT * FROM testTable WHERE ID = '1'", new RouteMapper())));

    }

    @AfterEach
    public void tearDown() {
     //   testTable.shutdown();
        jdbcTemplateTest.update("drop table testTable");
        System.out.println("testTable deleted");
    }
}


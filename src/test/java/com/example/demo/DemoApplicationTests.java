package com.example.demo;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClients;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@DataJpaTest
//@DataMongoTest
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class DemoApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ControllerDemo controllerDemo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test() throws Exception {
        assertThat(controllerDemo).isNotNull();
    }

    @Test
    public void helloTest() throws Exception {
        String route = "NSNSNSNSNS";

        mockMvc.perform(get("/hello?newRoute={route}", route))
                .andDo(print())
                .andExpect(content().string("This is a good route"));
    }

    @Test
    public void dbTest() throws Exception {

        String routeTest = "NSNSNSNSNS";
        int testId = 1;
        Route route = new Route(1, routeTest, Task.isItAGoodRoute(routeTest));
        DBObject objectToSave = BasicDBObjectBuilder.start()
                .add(route.getDescription(), route.getGoodorbad())
                .get();

        mongoTemplate.save(objectToSave, "collection");
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("NSNSNSNSNS")
                .containsOnly("This is a good route");

        mockMvc.perform(get("/hello?newRoute={route}", routeTest))
                .andDo(print())
                .andExpect(content().string("This is a good route"));
    }


}


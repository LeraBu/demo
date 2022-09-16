package com.example.demo;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.time.chrono.JapaneseDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest /*(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
class DemoApplicationTest {

  //  @LocalServerPort
  //  private int port;
  //  @Autowired
    private MockMvc mockMvc;

  //  private static final String CREATE = "scripts";

   // @Autowired
  //  private JdbcTemplate jdbcTemplate;

  // @MockBean
 // private AuthenticationManager authenticationManager;

  @Autowired
  private WebApplicationContext context;

//  @Autowired
//  private Filter springSecurityFilterChain;

  @BeforeTestMethod
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(context)
            .build();
  }

  private EmbeddedDatabase embeddedDatabase;


    String testDescription = "EWEWEWEWEW";
  //  private String baseURL;

    Route routeTest = new Route(1, testDescription, Task.isItAGoodRoute(testDescription));

  @Before
  public void setUp() {

    embeddedDatabase = new EmbeddedDatabaseBuilder()
            .addDefaultScripts()
            .setType(EmbeddedDatabaseType.H2)
            .build();

    JdbcTemplate jdbcTemplate = new JdbcTemplate(embeddedDatabase);


  }

  //  private static RestTemplate restTemplate;

   /* @Bean(name="entityManagerFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        return sessionFactory;
    } */


  //  @Autowired
  //  private TestH2Repository h2Repository;



    @Test
    public void addRoute() throws Exception {

      //  MvcResult result = mockMvc.perform(get("/hello?newRoute={route}", routeTest));


             //   ("/hello?newRoute={route}", routeTest));

      MvcResult result = mockMvc.perform(get("/hello?newRoute={route}", routeTest))
              .andDo(print())
              .andExpect(content().string("This is a good route"))
              .andReturn();

      //  Route response = restTemplate.postForObject(baseURL, routeTest, routeTest.getGoodorbad());// вероятно, тут нужно не Route.class, а routeTest.goodOrBAd
        assertEquals(routeTest.getGoodorbad(), result);

    }

}



 // private JdbcTemplate jdbcTemplate;

   /* @Repository
    public interface RouteRepository
            extends CrudRepository<Route, Integer> {
    }*/

  //  private PersonRepository personRepository;


      /*  DBObject objectToSave = BasicDBObjectBuilder.start()
                .add(route.getDescription(), route.getGoodorbad())
                .get(); */

//public interface TestH2Repository extends JpaRepository<Route, Integer> {}


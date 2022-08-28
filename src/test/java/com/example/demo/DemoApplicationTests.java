package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@ContextConfiguration(classes = {SpringConfig.class})
//@WebAppConfiguration
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DemoApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ControllerDemo controllerDemo;

    @Test
    public void test() throws Exception {
        assertThat(controllerDemo).isNotNull();
    }

    @Test
    public void helloTest() throws Exception {
        String route = "NSNSNSNSNS";
        mockMvc.perform(get("/hello?newRoute={route}", route))
                .andExpect(content().string("This is a good route"));
    }

}


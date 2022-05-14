package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {

    @GetMapping("/result")
    public String result(){
        String route = "NSEWNSWENSNNNNNNNN";
        String goodOrBad = Task.isItAGoodRoute(route);
        return goodOrBad;
    }
}


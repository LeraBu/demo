package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ControllerDemo {

    @GetMapping("/hello")
    public String getNewRoud(HttpServletRequest request){
        String newRoute = request.getParameter("newRoute");
        System.out.println("Route is " + newRoute);
        return Task.isItAGoodRoute(newRoute);
    }

    /* @GetMapping("/result")
    public String result(){
        String route = "NSEWNSWENSNNNNNNNN";
        String goodOrBad = Task.isItAGoodRoute(route);
        return goodOrBad;
    } */
}


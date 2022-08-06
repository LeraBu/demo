package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

@RestController
public class ControllerDemo {

    @GetMapping("/hello")
    public String getNewRoud(HttpServletRequest request) throws SQLException {
        String newRoute = request.getParameter("newRoute");
        System.out.println("Route is " + newRoute);
        System.out.println(Task.isItAGoodRoute(newRoute));
        return Task.isItAGoodRoute(newRoute);
    }
   @GetMapping("/allRoutes")
    public List<String> allRoutes(){
        List<String> index = RoutesDao.index();
    //    for (int i = 0; i<= index.size(); i++){
    //        System.out.println(index.get(i));
     //   }
        return index;
    }

}


package com.example.demo;

import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@RestController
public class ControllerDemo {

    private static int ROUTES_COUNT = 0;

    @GetMapping("/hello")
    public String getNewRout(HttpServletRequest request) throws SQLException {
        String newRoute = request.getParameter("newRoute");
        System.out.println("Route is " + newRoute);
        System.out.println(Task.isItAGoodRoute(newRoute));
        Route route = new Route(++ROUTES_COUNT, newRoute, Task.isItAGoodRoute(newRoute));
        RoutesDao.save(route);
        return Task.isItAGoodRoute(newRoute);

    }
   @GetMapping("/allRoutes")
    public List<Route> allRoutes(){
        List<Route> allRoutes = RoutesDao.index();
        return allRoutes;
    }

    // метод возвращает маршрут из дб по его id
    @GetMapping("/route{id}")
    public String show(@PathVariable("id") int id){
        return null;
    }

}


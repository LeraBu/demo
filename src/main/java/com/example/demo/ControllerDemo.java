package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.demo.DemoConnection.connection;
import static com.example.demo.DemoConnection.statement;

@RestController
public class ControllerDemo {

    @GetMapping("/hello")
    public String getNewRoud(HttpServletRequest request) throws SQLException {
        String newRoute = request.getParameter("newRoute");
        System.out.println("Route is " + newRoute);
        System.out.println(Task.isItAGoodRoute(newRoute));

       String SQL = "INSERT INTO RoutesOne VALUES(" + newRoute + "); commit;";
      //  ResultSet resultSet = statement.executeQuery(SQL);
     //    while (resultSet.next()){
          statement.executeUpdate(SQL);
      //  }

        return Task.isItAGoodRoute(newRoute);
    }



  /*  public ArrayList<Route> index(){
        ArrayList<Route> routes = new ArrayList<Route>();
        String SQL = "SELECT * FROM routes";
        ResultSet resultSet = DemoConnection.statement.executeQuery(SQL);

        while (resultSet.next()){
            Route route = new Route(resultSet.getInt("id"), resultSet.getString("description"));
          //  route.setId();
          //  route.setDescription();

            routes.add(route);
        }

            return routes;
    } */

    /* @GetMapping("/result")
    public String result(){
        String route = "NSEWNSWENSNNNNNNNN";
        String goodOrBad = Task.isItAGoodRoute(route);
        return goodOrBad;
    } */
}


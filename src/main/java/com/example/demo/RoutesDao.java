package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Component
public class RoutesDao {

    private static JdbcTemplate jdbcTemplate;
    @Autowired
    public RoutesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
   /* private static final String URL = "jdbc:postgresql://localhost:5432/Routes";
    private static final String PASSWORD = "123456789";
    private static final String USERNAME = "postgres";
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } */

   public static List<Route> index() {
       return jdbcTemplate.query("SELECT * FROM mythreetable", new RouteMapper());
   }

    public static void save(Route route, String tableName) {
        jdbcTemplate.update("INSERT INTO " + tableName + " VALUES(" + route.getId() + ", '" + route.getDescription() + "', '" + route.getGoodorbad() + "')");
    }

}

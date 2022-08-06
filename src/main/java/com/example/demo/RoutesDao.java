package com.example.demo;

import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoutesDao {

    private static final String URL = "jdbc:postgresql://localhost:5432/Routes";
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
    }

    public static List<String> index() {
        List<String> routesFromBD = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM databasethree";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                String route = resultSet.getString("route");
                routesFromBD.add(route);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routesFromBD;
    }
    public void save(String route) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO databasethree VALUES(" + "'" + route + "')";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}

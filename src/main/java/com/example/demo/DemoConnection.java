package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoConnection {
    public static final String USER_NAME = "postgres";
    public static final String PASSWORD = "123456789";
    public static final String URL = "jdbc:postgresql://localhost:5432/Routes";
    public static Statement statement;
    public static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try {
            statement = connection.createStatement();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException();
        }
    }

}


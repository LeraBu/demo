package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteMapper implements RowMapper<Route> {

    @Override
    public Route mapRow(ResultSet rs, int rowNum) throws SQLException {
        Route route = new Route(rs.getInt("id"), rs.getString("description"), rs.getString("goodorbad"));
        return route;
    }
}

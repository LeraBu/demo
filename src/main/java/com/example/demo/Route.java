package com.example.demo;

import org.springframework.stereotype.Component;

public class Route {
   // public static int ROUTES_COUNT = 0;
    private int id;
    private String description;
    private String goodorbad;

    public Route(int id, String description, String goodorbad) {
        this.id = id;
        this.description = description;
        this.goodorbad = goodorbad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoodorbad() {
        return goodorbad;
    }

    public void setGoodorbad(String goodorbad) {
        this.goodorbad = goodorbad;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", goodorbad='" + goodorbad + '\'' +
                '}';
    }
}

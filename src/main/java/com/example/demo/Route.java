package com.example.demo;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testdb")
public class Route {
    @Id
    private int id;
    private String description;
    private String goodorbad;

    public Route() {
    }

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
/*
<dependency>
<groupId>javax.persistence</groupId>
<artifactId>persistence-api</artifactId>
<version>1.0.2</version>
</dependency>

 */

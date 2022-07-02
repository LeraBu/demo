package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.example.demo.DemoConnection.statement;

@SpringBootApplication
public class DemoApplication {

	public DemoApplication() {
	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

}

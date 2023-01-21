package com.accelerate.mohammedi.itunes.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Chinook_Database {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    public Chinook_Database() {

    }

    public Connection connection(){
        try {
            Connection conn = DriverManager.getConnection(url, username,password);
            System.out.println("Connected to Chinook database...");
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}

package com.accelerate.mohammedi.itunes.chinookDAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ChinoookDAO {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    public ChinoookDAO() {
    }

    public ChinoookDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void connection(){
        try {
            Connection conn = DriverManager.getConnection(url, username,password);
            System.out.println("Connected to Chinook database..." + conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.accelerate.mohammedi.itunes.models;

import com.accelerate.mohammedi.itunes.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class Customer implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public int customer_id;
    public String first_name;
    public String last_name;
    public String company;
    public String address;
    public String city;
    public String state;
    public String country;
    public String postal_code;
    public String phone;
    public String email;




    public Customer() {
    }

    public Customer(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void read_All_Customer(){
        try {
            Connection conn = DriverManager.getConnection(url, username,password);
            System.out.println("Connected to Chinook database...");
            ArrayList<Customer> customers = getAll();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet test = statement.executeQuery();

            while(test.next()){
                customer_id = test.getInt("customer_id");
                first_name = test.getString("first_name");
                System.out.print(customer_id + " " +  first_name + " ");
                System.out.println();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer getById(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> customer = new ArrayList<Customer>();
        return customer;
    }

    @Override
    public void create(Customer object) {

    }

    @Override
    public void update(Customer object) {

    }

    @Override
    public void delete(Integer integer) {

    }
}

package com.accelerate.mohammedi.itunes.service;
import com.accelerate.mohammedi.itunes.database.Chinook_Database;
import com.accelerate.mohammedi.itunes.models.Customer;
import com.accelerate.mohammedi.itunes.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerImplementation extends Customer implements CustomerRepository {

    /**
     * method for reading all the customer from the database and saving it to an arraylist for reading
     * @return new arraylist containing all the customer by name, country postal code phone number and email
     */
    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> arrayList = new ArrayList<Customer>();
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer_id = get_value_from_row.getInt("customer_id");
                first_name = get_value_from_row.getString("first_name");
                last_name = get_value_from_row.getString("last_name");
                country = get_value_from_row.getString("country");
                postal_code = get_value_from_row.getString("postal_code");
                phone = get_value_from_row.getString("phone");
                email = get_value_from_row.getString("email");
                Customer customer = new Customer(customer_id, first_name, last_name, country, postal_code, phone, email);
                arrayList.add(customer);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    /**
     * Method for getting a customer by id and returning the customer object
     * @param id take the int parameter
     * @return customer object containing the id, name, country, postal code, phone and email
     */
    @Override
    public Customer getById(Integer id) {
        Customer customer = null;
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer where customer_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer_id = get_value_from_row.getInt("customer_id");
                first_name = get_value_from_row.getString("first_name");
                last_name = get_value_from_row.getString("last_name");
                country = get_value_from_row.getString("country");
                postal_code = get_value_from_row.getString("postal_code");
                phone = get_value_from_row.getString("phone");
                email = get_value_from_row.getString("email");
                customer = new Customer(customer_id, first_name, last_name, country, postal_code, phone, email);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.toString());
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

    @Override
    public String toString() {
        return  customer_id +
                " " +
                first_name +
                " " +
                last_name +
                " " +
                country +
                " " +
                postal_code +
                " " +
                phone +
                " " +
                email;
    }
}

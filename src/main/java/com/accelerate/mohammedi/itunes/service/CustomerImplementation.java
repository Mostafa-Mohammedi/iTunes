package com.accelerate.mohammedi.itunes.service;
import com.accelerate.mohammedi.itunes.models.Customer;
import com.accelerate.mohammedi.itunes.models.Invoice;
import com.accelerate.mohammedi.itunes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerImplementation implements CustomerRepository {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


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


    /**
     * Task 1
     * method for reading all the customer from the database and saving it to an arraylist for reading
     * @return new arraylist containing all the customer by name, country postal code phone number and email
     */
    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> arrayList = new ArrayList<Customer>();
        Customer customer = new Customer();
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.customer_id = get_value_from_row.getInt("customer_id");
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.country = get_value_from_row.getString("country");
                customer.postal_code = get_value_from_row.getString("postal_code");
                customer.phone = get_value_from_row.getString("phone");
                customer.email = get_value_from_row.getString("email");
                customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
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
     * Task 2
     * Method for getting a customer by id and returning the customer object
     * @param id take the int parameter
     * @return customer object containing the id, name, country, postal code, phone and email
     */
    @Override
    public Customer getById(Integer id) {
        Customer customer = new Customer();
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer where customer_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.customer_id = get_value_from_row.getInt("customer_id");
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.country = get_value_from_row.getString("country");
                customer.postal_code = get_value_from_row.getString("postal_code");
                customer.phone = get_value_from_row.getString("phone");
                customer.email = get_value_from_row.getString("email");
                customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.toString());
        return customer;
    }

    /**
     * Task 3
     * method for returning the customer by name searches for first and last name
     * @param name take a string name parameter
     * @return a customer object
     */
    @Override
    public Customer getByName(String name) {
        Customer customer = new Customer();

        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email " +
                    "from customer " +
                    "where first_name like ? or last_name like ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"%" + name.replace("'", "") + "%");
            statement.setString(2,"%" + name.replace("'", "") + "%");
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.customer_id = get_value_from_row.getInt("customer_id");
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.country = get_value_from_row.getString("country");
                customer.postal_code = get_value_from_row.getString("postal_code");
                customer.phone = get_value_from_row.getString("phone");
                customer.email = get_value_from_row.getString("email");
                customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.toString());
        return customer;
    }

    /**
     * task 4
     * Method for returning a list of customer.
     * Pagination is added through the limit and offset method  where user sets the limit of customer that he want to search for and where to start to search for
     * @param customer takes instance of the customer
     * @param limit takes the limit of customer that he want to search for
     * @param offset takes the input for where to start searching from
     * @return a list of customer
     */
    @Override
    public List<Customer> pageCustomer(Customer customer, int limit, int offset) {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer order by customer_id asc limit ? offset ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,limit);
            statement.setInt(2,offset);

            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.customer_id = get_value_from_row.getInt("customer_id");
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.country = get_value_from_row.getString("country");
                customer.postal_code = get_value_from_row.getString("postal_code");
                customer.phone = get_value_from_row.getString("phone");
                customer.email = get_value_from_row.getString("email");
                customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
                customers.add(customer);
                System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //system.out.println(customer.toString());
        return customers;
    }

    /**
     * Task 5
     * method for creating a customer by adding a new customer object
     * @param customer takes a customer object
     */
    @Override
    public void create(Customer customer) {
        try {
            Connection conn = connection();
            String sql = "insert into customer(customer_id, first_name, last_name, country, postal_code, phone, email)" +
                    "values (?, ?, ?, ?, ?,?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,customer.customer_id);
            statement.setString(2, customer.first_name);
            statement.setString(3, customer.last_name);
            statement.setString(4, customer.country);
            statement.setString(5, customer.postal_code);
            statement.setString(6, customer.phone);
            statement.setString(7, customer.email);


            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.customer_id = get_value_from_row.getInt("customer_id");
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.country = get_value_from_row.getString("country");
                customer.postal_code = get_value_from_row.getString("postal_code");
                customer.phone = get_value_from_row.getString("phone");
                customer.email = get_value_from_row.getString("email");
                customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(customer.toString());
    }

    /**
     * task 6
     * updating an existing customer name, country, postal code, phone and email
     * @param customer take a customer object as parameter
     */
    @Override
    public void update(Customer customer) {

        try {
            Connection conn = connection();
            String sql = "update customer set first_name = ?, last_name = ?, country = ?, postal_code = ?, phone = ?, email = ? where customer_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.first_name);
            statement.setString(2, customer.last_name);
            statement.setString(3, customer.country);
            statement.setString(4, customer.postal_code);
            statement.setString(5, customer.phone);
            statement.setString(6, customer.email);
            statement.setInt(7,customer.customer_id);
            statement.executeUpdate();
            statement.close();
            customer = new Customer(customer.customer_id, customer.first_name, customer.last_name, customer.country, customer.postal_code, customer.phone, customer.email);
            //System.out.println(customer.toString());
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");


    }

    /**
     * Task 7
     * method for returning the country with most customer
     */
    @Override
    public void countryMostCustomer() {
        Customer customer = new Customer();
        try {
            Connection conn = connection();
            String sql = "select country, count(country) from customer group by country order by count(country) desc limit 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet get_value_from_row = statement.executeQuery();


            while(get_value_from_row.next()){
                customer.country = get_value_from_row.getString("country");

                System.out.println(customer.country);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");
    }

    /**
     * Task 8
     * method for returning the customer object with higest spent amount
     * @return a customer object with the total amount as a parameter
     */

    public Customer customer_most_total() {
        Customer customer = new Customer();
        Invoice invoice = new Invoice();
        try {
            Connection conn = connection();
            String sql = "select customer.customer_id, " +
                    "customer.first_name," +
                    " customer.last_name,  " +
                    "sum (invoice.total) as total" +
                    " from customer" +
                    " join invoice " +
                    "on invoice.customer_id = customer.customer_id group by customer.customer_id order by sum(invoice.total) desc limit 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet get_value_from_row = statement.executeQuery();
            while(get_value_from_row.next()){
                customer.first_name = get_value_from_row.getString("first_name");
                customer.last_name = get_value_from_row.getString("last_name");
                customer.total  = get_value_from_row.getDouble("total");
                customer = new Customer(customer.first_name, customer.last_name, customer.total);
                System.out.println(customer.first_name + " "+ customer.last_name + " " + customer.total);

            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");

        return customer;
    }


}

package com.accelerate.mohammedi.itunes.service;
import com.accelerate.mohammedi.itunes.models.*;
import com.accelerate.mohammedi.itunes.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author  Mostafa Mohammedi
 * CustomerImplementation class contains all the business logic of the Customer repository
 */
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

    private Customer getCustomerData(ResultSet dbResult) throws SQLException {
        int customer_id = dbResult.getInt("customer_id");
        String firstName = dbResult.getString("first_name");
        String lastName = dbResult.getString("last_name");
        String country = dbResult.getString("country");
        String postalCode = dbResult.getString("postal_code");
        String phone = dbResult.getString("phone");
        String email = dbResult.getString("email");
        return new Customer(customer_id, firstName, lastName, country, postalCode, phone, email);
    }


    /**
     * Task 1
     * method for reading all the customer from the database and saving it to an arraylist for reading
     * @return new arraylist containing all the customer by name, country postal code phone number and email
     */

    @Override
    public List<Customer> getAll() {
        ArrayList<Customer> arrayList = new ArrayList<>();
        Customer customer = null;
        try {
            Connection conn = connection();
            String sql = "select customer_id, first_name, last_name, country, postal_code, phone, email from customer";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                customer = getCustomerData(dbResult);
                arrayList.add(customer);
               // System.out.println(customer);
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
            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                customer = getCustomerData(dbResult);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                customer = getCustomerData(dbResult);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
                customer = getCustomerData(get_value_from_row);
                customers.add(customer);
                System.out.println(customer);
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
     *
     * @param customer takes a customer object
     * @return
     */
    @Override
    public Customer create(Customer customer) {
        try {
            Connection conn = connection();
            String sql = "insert into customer(customer_id, first_name, last_name, country, postal_code, phone, email)" +
                    "values (?, ?, ?, ?, ?,?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,customer.getCustomerId());
            statement.setString(2,customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getCountry());
            statement.setString(5, customer.getPostalCode());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());

            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                customer = getCustomerData(dbResult);
                //System.out.println(customer.toString());
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    /**
     * task 6
     * updating an existing customer name, country, postal code, phone and email
     * @param customer take a customer object as parameter
     */
    @Override
    public Customer update(Customer customer) {

        try {
            Connection conn = connection();
            String sql = "update customer set first_name = ?, last_name = ?, country = ?, postal_code = ?, phone = ?, email = ? where customer_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getCountry());
            statement.setString(4, customer.getPostalCode());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setInt(7,customer.getCustomerId());
            statement.executeUpdate();
            statement.close();
             customer = new Customer(customer.getCustomerId(),customer.getFirstName(), customer.getLastName(), customer.getCountry(), customer.getPostalCode(), customer.getPhone(), customer.getEmail());
            //System.out.println(customer.toString());
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");
        return customer;
    }

    /**
     * Task 7
     * method for returning the country with most customer
     *
     * @return
     */
    @Override
    public CustomerCountry countryMostCustomer() {
        CustomerCountry customerCountry = null;
        try {
            Connection conn = connection();
            String sql = "select country, count(country) from customer group by country order by count(country) desc limit 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet dbResult = statement.executeQuery();
            while(dbResult.next()){
                String country= dbResult.getString("country");
                customerCountry = new CustomerCountry(new Country(country));
            }
            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");
        return customerCountry;
    }

    /**
     * Task 8
     * method for returning the customer object with higest spent amount
     * @return a customer object with the total amount as a parameter
     */
    @Override
    public CustomerSpender customer_most_total() {
        CustomerSpender customer = null;
        try {
            Connection conn = connection();
            String sql = "select customer.customer_id, " +
                    "customer.first_name," +
                    " last_name,  " +
                    "sum (invoice.total) as total" +
                    " from customer" +
                    " join invoice " +
                    "on invoice.customer_id = customer.customer_id group by customer.customer_id order by sum(invoice.total) desc limit 1";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet dbResult = statement.executeQuery();
            while (dbResult.next()){
                int customer_id = dbResult.getInt("customer_id");
                String firstName = dbResult.getString("first_name");
                String lastName = dbResult.getString("last_name");
                int total  = dbResult.getInt("total");
                customer = new CustomerSpender(new Invoice(customer_id, firstName, lastName), total);
                System.out.println(firstName + " "+ lastName + " " + total);
            }

            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");

        return customer;
    }

    /**
     * Task 9
     * For a given customer, their most popular genre (in the case of a tie, display both). Most popular in this context
     * Means the genre that corresponds to the most tracks from invoices associated to that customer.
     */

    @Override
    public CustomerGenre most_popularGenre(int id){
        CustomerGenre customer = null;
        List<String> genreName = new ArrayList<String>();
        try {
            Connection conn = connection();
            String sql =
                    "select customer_id, first_name,last_name,count as popular,genre from" +
                    "(select c.customer_id, c.first_name, c.last_name, count(*),g.name  as genre,RANK () OVER ( " +
                    "partition by c.customer_id " +
                    "ORDER BY count(*) DESC) as rank" +
                    " from customer as c" +
                    " join invoice as i on c.customer_id=i.customer_id" +
                    " join invoice_line il on il.invoice_id=i.invoice_id" +
                    " join track as t on t.track_id=il.track_id" +
                    " join genre as g on g.genre_id=t.genre_id where c.customer_id=?" +
                    " group by c.customer_id,g.name) as a where rank=1";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet dbResult = statement.executeQuery();
            while (dbResult.next()){
                int customer_id = dbResult.getInt("customer_id");
                String first_name= dbResult.getString("first_name");
                String last_name = dbResult.getString("last_name");
                int countPopularityGenre  = dbResult.getInt("popular");
                String customerFavoriteGenre = dbResult.getString("genre");
                genreName.add(customerFavoriteGenre);
                customer = new CustomerGenre(new Genre(customer_id,first_name, last_name), countPopularityGenre, genreName);
            }

            //System.out.println(customers);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("database is updated");

        return customer;
    }
}


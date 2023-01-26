package com.accelerate.mohammedi.itunes.repository;

import com.accelerate.mohammedi.itunes.models.Customer;
import com.accelerate.mohammedi.itunes.models.CustomerCountry;
import com.accelerate.mohammedi.itunes.models.CustomerGenre;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Integer, Customer>{

    Customer getByName(String name);
    List<Customer> pageCustomer(Customer customer, int limit, int offset);
    CustomerCountry countryMostCustomer();
    Customer customer_most_total();
    CustomerGenre most_popularGenre(int id);

}

package com.accelerate.mohammedi.itunes.repository;

import com.accelerate.mohammedi.itunes.models.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Integer, Customer>{

    Customer getByName(String name);
    List<Customer> pageCustomer(Customer customer, int limit, int offset);
    void countryMostCustomer();
    Customer customer_most_total();

}

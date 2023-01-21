package com.accelerate.mohammedi.itunes.repository;

import com.accelerate.mohammedi.itunes.models.Customer;

public interface CustomerRepository extends CrudRepository<Integer, Customer>{

    Customer getByName(String name);


}

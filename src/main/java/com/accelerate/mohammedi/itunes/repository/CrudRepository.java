package com.accelerate.mohammedi.itunes.repository;
import com.accelerate.mohammedi.itunes.models.Customer;

import java.util.List;

public interface CrudRepository <ID, T>{
    //Crud
    T getById(ID id);
    List<T> getAll();

    Customer create(T object);

    T update(T object);

}

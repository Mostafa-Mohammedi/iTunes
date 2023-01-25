package com.accelerate.mohammedi.itunes.repository;

import com.accelerate.mohammedi.itunes.models.Customer;

import java.util.ArrayList;

public interface CrudRepository <ID, T>{
    //Crud
    T getById(ID id);
    ArrayList<T> getAll();

    void create(T object);

    T update(T object);

}

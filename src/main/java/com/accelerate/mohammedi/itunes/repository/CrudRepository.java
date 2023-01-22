package com.accelerate.mohammedi.itunes.repository;

import java.util.ArrayList;

public interface CrudRepository <ID, T>{
    //Crud
    T getById(ID id);
    ArrayList<T> getAll();

    void create(T object);

    void update(T object);


}

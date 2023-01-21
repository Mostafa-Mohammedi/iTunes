package com.accelerate.mohammedi.itunes.repositories;

import java.util.ArrayList;
import java.util.List;

public interface CrudRepository <ID, T>{
    //Crud
    T getById(ID id);
    ArrayList<T> getAll();

    void create(T object);

    void update(T object);
    void delete(ID id);


}

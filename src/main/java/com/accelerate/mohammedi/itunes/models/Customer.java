package com.accelerate.mohammedi.itunes.models;
import com.accelerate.mohammedi.itunes.database.Chinook_Database;
import org.springframework.stereotype.Repository;

@Repository
public class Customer extends Chinook_Database {
    public int customer_id;
    public String first_name;
    public String last_name;
    public String country;
    public String postal_code;
    public String phone;
    public String email;


    public Customer() {

    }

    public Customer(int customer_id, String first_name, String last_name, String country, String postal_code, String phone, String email) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.country = country;
        this.postal_code = postal_code;
        this.phone = phone;
        this.email = email;
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

package com.accelerate.mohammedi.itunes.models;

public class Genre {
    private int customerId;
    private String firstName;
    private String lastName;


    public Genre(int customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Genre " + "customerId: " + customerId + " firstName: " + firstName + " lastName: " + lastName;
    }
}

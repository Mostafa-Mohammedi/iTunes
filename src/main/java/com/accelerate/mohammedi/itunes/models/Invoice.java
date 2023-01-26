package com.accelerate.mohammedi.itunes.models;

public class Invoice {
    private int customer_Id;
    private String firstName;
    private String lastName;

    public Invoice(int customer_Id, String firstName, String lastName) {
        this.customer_Id = customer_Id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Invoice: " + "customer_Id: " + customer_Id + " firstName='" + firstName  + " lastName='" + lastName;
    }
}

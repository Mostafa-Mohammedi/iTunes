package com.accelerate.mohammedi.itunes.models;

/**
 * Customer class is the entity class for containing  the data model for the customer class for querying the business logic
 */
public class Customer  {
    private int customerId;
    private String firstName;
    private String lastName;
    private String country;
    private String postalCode;
    private String phone;
    private String email;
    private CustomerSpender totalInvoice;

    public Customer() {

    }

    public Customer(int customerId, String firstName, String lastName, CustomerSpender totalInvoice) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalInvoice = totalInvoice;
    }

    public Customer(int customer_id, String firstName, String lastName, CustomerGenre genreName) {
        this.customerId = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(int customer_id, String firstName, String lastName, String country, String postalCode, String phone, String email) {
        this.customerId = customer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.postalCode = postalCode;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return  customerId +
                " " +
                firstName +
                " " +
                lastName +
                " " +
                country +
                " " +
                postalCode +
                " " +
                phone +
                " " +
                email;
    }
}

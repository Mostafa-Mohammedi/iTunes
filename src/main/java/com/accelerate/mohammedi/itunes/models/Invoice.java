package com.accelerate.mohammedi.itunes.models;

public class Invoice {
    protected int customer_id;
    protected String billing_address;
    protected String Billing_country;
    protected double total;

    public Invoice() {
    }

    public Invoice(int customer_id, String billing_address, String billing_country, double total) {
        this.customer_id = customer_id;
        this.billing_address = billing_address;
        Billing_country = billing_country;
        this.total = total;
    }

    @Override
    public String toString() {
        return "customer_id " + customer_id +
                " billing_address " + billing_address  +
                " Billing_country " + Billing_country  +
                " total " + total;
    }
}

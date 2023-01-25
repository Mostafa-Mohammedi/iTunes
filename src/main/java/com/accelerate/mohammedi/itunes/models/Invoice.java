package com.accelerate.mohammedi.itunes.models;

public class Invoice {
    public int customer_id;
    public String billing_address;
    public String Billing_country;
    public double total;

    public Invoice() {
    }

    public Invoice(double total) {
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

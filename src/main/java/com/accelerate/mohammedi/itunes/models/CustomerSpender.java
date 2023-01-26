package com.accelerate.mohammedi.itunes.models;

/**
 * Invoice class for getting the total invoice
 */
public class CustomerSpender extends Customer {

    private Invoice invoice;
    private  int total;

    public CustomerSpender(Invoice invoice, int total) {
        this.invoice = invoice;
        this.total = total;
    }

    @Override
    public String toString() {
        return "invoice:  " + invoice + " total " + total;
    }
}

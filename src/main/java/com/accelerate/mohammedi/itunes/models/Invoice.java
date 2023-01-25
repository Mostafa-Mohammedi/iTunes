package com.accelerate.mohammedi.itunes.models;

/**
 * Invoice class for getting the total invoice
 */
public class Invoice {
    private final int total;

    public Invoice(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return " total " + total;
    }
}

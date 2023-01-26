package com.accelerate.mohammedi.itunes.models;

public class CustomerCountry {
    private Country countryName;

    public CustomerCountry(Country countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "CustomerCountry: " +  countryName;
    }
}

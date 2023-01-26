package com.accelerate.mohammedi.itunes.models;

public class Country {
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name;
    }
}

package com.accelerate.mohammedi.itunes.models;


import java.util.List;

public class CustomerGenre {

    private Genre genre;

    private int count;
    private List<String> GenreName;


    public CustomerGenre(Genre genre,int count, List<String> genreName) {
        this.genre = genre;
        this.count = count;
        this.GenreName = genreName;
    }

    @Override
    public String toString() {
        return "CustomerGenre" + "genre: " + genre + " count: " + count + " GenreName: " + GenreName;
    }
}

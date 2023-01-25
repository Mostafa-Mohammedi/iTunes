package com.accelerate.mohammedi.itunes.models;

import java.util.ArrayList;

public class Genre {

    private int totalNumberPopularityGenre;
    private ArrayList<String> name;

    public Genre(int totalNumberPopularityGenre, ArrayList<String> name) {
        this.totalNumberPopularityGenre = totalNumberPopularityGenre;
        this.name = name;
    }
}

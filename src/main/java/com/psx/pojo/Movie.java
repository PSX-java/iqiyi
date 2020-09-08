package com.psx.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor

public class Movie {
    private int id;
    private String mviename;
    private String director;
    private int movietime;
    private String moviedes;
    private String moviecover;
    private Date release_date;
    private String movie_stars;

    public Movie(int id, String mviename, String director, int movietime, String moviedes, String moviecover,  String movie_stars) {
        this.id = id;
        this.mviename = mviename;
        this.director = director;
        this.movietime = movietime;
        this.moviedes = moviedes;
        this.moviecover = moviecover;
        this.release_date = new Date();
        this.movie_stars = movie_stars;
    }
}

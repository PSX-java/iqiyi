package com.psx.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


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
    // 一个电影会有多个演员,一对多的关系
    private List<Actor> actors;
    // 一个电影有多个类型,一对多的关系
    private String types;
    private List<Type> typeList;

    public Movie(int id,List<Type> typeList,List<Actor> actors, String mviename,String types, String director, int movietime, String moviedes, String moviecover,  String movie_stars) {
        this.id = id;
        this.actors=actors;
        this.typeList=typeList;
        this.types=types;
        this.mviename = mviename;
        this.director = director;
        this.movietime = movietime;
        this.moviedes = moviedes;
        this.moviecover = moviecover;
        this.release_date = new Date();
        this.movie_stars = movie_stars;
    }
}

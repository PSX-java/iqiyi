package com.psx.controller;


import com.psx.mapper.MovieMapper;
import com.psx.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieMapper movieMapper;

    //查询全部数据
    @GetMapping("/queryMovieList")
    public List<Movie> queryMovieList(){
        List<Movie> movieList =movieMapper.queryMovieList();
        for(Movie movie: movieList){
            System.out.println(movie);
        }
        return movieList;
    }

//    添加电影
    @GetMapping("/addMovie")
    public List<Movie> addMovie(Movie movie){
       movieMapper.addMovie(movie);
    List<Movie> movies =movieMapper.queryMovieList();
       return movies;
    }

    //修改电影
    @GetMapping("/updateMovie")
    public String updateMovie(Movie movie){
        movieMapper.updateMovie(movie);
       return "ok";
    }

    //删除一条电影数据
    @GetMapping("/deleteMovie")
    public String deleteMovie(){
        movieMapper.deleteMovie(4);
        return "ok";
    }
}

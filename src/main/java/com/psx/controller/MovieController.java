package com.psx.controller;


import com.psx.mapper.MovieMapper;
import com.psx.pojo.Movie;
import com.psx.pojo.MovieAndType;
import com.psx.pojo.Type;
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
    public void addMovie(Movie movie){
        // 1.向movie表中插入一条记录
       movieMapper.addMovie(movie);
       int mid =movie.getId();
        System.out.println("id==" + mid);
        // 2.向电影和类型的中间表中插入记录:
    List<Type> types =movie.getTypes();
    for (Type type :types){
        int typeid =type.getId();
        MovieAndType mac =new MovieAndType(mid,typeid);
        movieMapper.insertMovieAndType(mac);
    }

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
    //电影数量统计

}

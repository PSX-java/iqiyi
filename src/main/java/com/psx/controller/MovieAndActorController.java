package com.psx.controller;

import com.psx.mapper.ActorMapper;
import com.psx.mapper.MovieMapper;
import com.psx.pojo.Actor;
import com.psx.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieAndActorController {

    @Autowired
    private MovieAndActorController movieAndActorController;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ActorMapper actorMapper;

    //显示信息
    @GetMapping("/edit")
    public Map<String,Object> editMovieAndActor(int movieid){
          /*
        1.2 接口的逻辑:
            根据电影的id查询出电影的数据: movie
            查询所有的电影: movieList
            查询出所有的演员: actorList
        */
        // 根据电影的id查询出电影的数据: movie
        Movie movie =movieMapper.findById(movieid);
        List<Movie> movieList =movieMapper.queryMovieList();
        List<Actor> actorList =actorMapper.findAll();

        Map<String,Object> map =new HashMap<>();
        map.put("movie",movie);
        map.put("movieList",movieList);
        map.put("actorList",actorList);
        return map;
    }

    //添加电影和演员
    @PostMapping("/save")
    public String save(Movie movie){
        movieAndActorController.save(movie);
        return "提交成功";
    }
}


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
    public List<Movie> addMovie(){
       movieMapper.addMovie(new Movie(3,"与神同行","金容华",156,"阴间有法，所有亡者在死后的49天内都要经过七次审判——分别在杀人狱、懒惰狱、欺骗狱、不义狱、背叛狱、暴力狱、天伦狱中进行，只有通过了七次审判宣告无罪的亡者，才有获得新生的机会。","kho","河正宇、车太贤、朱智勋、金香奇 、金东旭、都敬秀"));
    List<Movie> movies =movieMapper.queryMovieList();
       return movies;
    }

    //修改电影
    @GetMapping("/updateMovie")
    public String updateMovie(){
        movieMapper.updateMovie(new Movie(3,"放牛班的春天","克里斯托夫·巴拉蒂",96,"讲述的是一位怀才不遇的音乐老师马修来到辅育院，面对的不是普通学生，而是一群被大人放弃的野男孩，马修改变了孩子以及他自己的命运的故事。","1213","杰拉尔·朱诺、让-巴蒂斯特·莫尼耶、弗朗西斯·贝尔兰德"));
       return "ok";
    }

    //删除一条电影数据
    @GetMapping("/deleteMovie")
    public String deleteMovie(){
        movieMapper.deleteMovie(4);
        return "ok";
    }
}

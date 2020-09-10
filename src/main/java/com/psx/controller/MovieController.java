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
        System.out.println(movie.getTypes());
        // 2.向电影和类型的中间表中插入记录:
        String types =movie.getTypes();
        String[] typeArray = types.split(",");
          for (String cid:typeArray){

        MovieAndType mac =new MovieAndType(mid,Integer.parseInt(cid));
        movieMapper.insertMovieAndType(mac);
    }

    }

    //修改电影
    @GetMapping("/updateMovie")
    public void updateMovie(Movie movie){
        // 1.更新电影表
        movieMapper.updateMovie(movie);
        // 2.更新电影与类型的中间表的记录
        // 2.1.先删除中间表中的相关记录:根据电影的id删除记录
        movieMapper.deleteMovieAndType(movie.getId());
        // 2.2.在插入相关的记录:向中间表中插入新的记录
        // 页面上传递过来的电影存储在movie的categories中, 使用逗号连接起来的字符串: 1,3
        // 分割电影类型的id
        String types =movie.getTypes();
        // ["1", "3"]
       String[] typeids =types.split(",");
       for (String cid:typeids){
           MovieAndType mac =new MovieAndType(movie.getId(),Integer.parseInt(cid));
           movieMapper.insertMovieAndType(mac);
       }
    }


    //删除一条电影数据
    @GetMapping("/deleteMovie")
    public String deleteMovie(){
        movieMapper.deleteMovie(4);
        return "ok";
    }
    //电影数量统计

}

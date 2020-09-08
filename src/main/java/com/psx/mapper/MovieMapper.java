package com.psx.mapper;

import com.psx.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//这个注解表示了这是一个mybatis的mapper类
@Mapper
@Repository
public interface MovieMapper {
    List<Movie> queryMovieList();
    Movie queryMovieByName(Movie movie);
    int addMovie(Movie movie);
    int updateMovie(Movie movie);
    int deleteMovie(Movie movie);
}

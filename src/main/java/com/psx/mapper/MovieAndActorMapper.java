package com.psx.mapper;

import com.psx.pojo.MovieAndActor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MovieAndActorMapper {
    public void save(MovieAndActor movieAndActor);
}

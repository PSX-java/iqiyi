package com.psx.mapper;


import com.psx.pojo.Actor;
import com.psx.pojo.Actor_Region;
import com.psx.pojo.MovieAndType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ActorMapper {
    // 查询演员列表
    public List<Actor> findAll();

    // 添加
    public int addActor(Actor actor);

    // 根据id查询
    public Actor findById(int id);

    // 更新一条记录
    public int  updateActor(Actor actor);

    //删除
    int deleteActor(int id);

    //添加区域
    public int insertActorAndRegion(Actor_Region mac);
}

package com.psx.mapper;


import com.psx.pojo.Actor;
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
    public void update(Actor actor);

    //删除

}

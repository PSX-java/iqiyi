package com.psx.controller;

import com.psx.pojo.Actor;
import com.psx.mapper.ActorMapper;
import com.psx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ActorController {

  @Autowired
private ActorMapper actorMapper;

    //查询
    @GetMapping("/findAll")
    public List<Actor> findAll(){
        List<Actor> actors =actorMapper.findAll();
        return actors;
    }

    //添加
    @GetMapping("/addActor")
    public String addActor(Actor actor){
        actorMapper.addActor( actor);
        return  "数据已添加";
    }
}
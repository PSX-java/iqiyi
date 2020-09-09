package com.psx.controller;

import com.psx.pojo.*;
import com.psx.mapper.ActorMapper;
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
        int mid =actor.getId();
        System.out.println("id=="+mid);
        //向电影和类型的中间表中插入记录：
        List<Type> types =actor.getRegions();
        for (Type c :types){
            int cid =c.getId();
            Actor_Region mac =new Actor_Region(mid,cid);
            actorMapper.insertACtorAndRegion(mac);
        }
        return  "数据已添加";
    }

}
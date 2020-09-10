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
    public String addActor(Actor actor ){

        actorMapper.addActor( actor);
        int mid =actor.getId();
        System.out.println("id=="+mid);
        //向演员和类型的中间表中插入记录：
        List<Region> regions =actor.getRegions();
        for (Region c :regions){
            int cid =c.getId();
            Actor_Region mac =new Actor_Region(mid,cid);
            actorMapper.insertActorAndRegion(mac);
        }
        return  "数据已添加";
    }

    //更新
    @GetMapping("/updateActor")
    public String updateActor(Actor actor){
      actorMapper.updateActor(actor);
      return "数据已更改";
    }

    //删除
    @GetMapping("deleteActor")
    public String deleteActor(int id){
        actorMapper.deleteActor(id);
        return "ok";
    }

}
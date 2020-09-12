package com.psx.controller;

import com.psx.pojo.*;
import com.psx.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(actor.getRegions());
        //向演员和类型的中间表中插入记录：
        String region =actor.getRegion();
        String[] regionArray = region.split(",");
        for (String cid :regionArray){
            Actor_Region mac =new Actor_Region(mid,Integer.parseInt(cid));
            actorMapper.insertActorAndRegion(mac);
        }
        return  "数据已添加";
    }

    //更新
    @GetMapping("/updateActor")
    public String updateActor(Actor actor){
        // 1.更新电影表
      actorMapper.updateActor(actor);
        // 2.更新电影与类型的中间表的记录
        // 2.1.先删除中间表中的相关记录:根据电影的id删除记录
        actorMapper.deleteActorAndRegions(actor.getId());
        // 2.2.在插入相关的记录:向中间表中插入新的记录
        // 页面上传递过来的电影存储在movie的categories中, 使用逗号连接起来的字符串: 1,3
        // 分割演员区域的id
        String regions =actor.getRegion();

        String[] regionids=regions.split(",");
        for (String cid :regionids){
            Actor_Region mac=new Actor_Region(actor.getId(),Integer.parseInt(cid));
            actorMapper.insertActorAndRegion(mac);
        }
      return "数据已更改";
    }

    //删除
    @GetMapping("deleteActor")
    public String deleteActor(int id){
        actorMapper.deleteActorAndRegions(id);
        actorMapper.deleteActor(id);
        return "ok";
    }

}
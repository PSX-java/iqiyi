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
    public String addActor(){
        actorMapper.addActor(new Actor(3,
                "刘亦菲",null,
                "0",
                "华语影视女演员、歌手，毕业于北京电影学院2002级表演系本科。2002年，因出演电视剧《金粉世家》中白秀珠一角踏入演艺圈 [1]  。2003年因主演武侠剧《天龙八部》崭露头角 [2]  。2004年凭借仙侠剧《仙剑奇侠传》赵灵儿一角获得了高人气与关注度 [3]  。2005年因在武侠剧《神雕侠侣》中饰演小龙女受到广泛关注.",
                "",
                null));
        return  "数据已添加";
    }
}
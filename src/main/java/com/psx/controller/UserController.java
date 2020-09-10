package com.psx.controller;

import com.psx.mapper.UserMapper;
import com.psx.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



/**
 * 与爱奇艺项目无关
 * */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

//    查询全部数据
    @GetMapping("/queryUSerList")
    public List<User> queryUSerList(){
        List<User> userList =userMapper.queryUserList();
        for (User user : userList){
            System.out.println(user);
        }
        return userList;
    }

    @GetMapping("/queryUserById")
    public User queryUserById( int usersid){
        User user =new User();
        user.setUsersid(usersid);

        return userMapper.queryUserById(user);
    }
//添加
    @GetMapping("/addUser")
    public String addUser(){
        userMapper.addUser(new User(4,"公孙夏","88888","0"));
        return  "数据已添加";
    }
//更新
    @GetMapping("/updateUser")
    public String updateUser(){
        userMapper.updateUser(new User(5,"大白","5555","0"));
    return "ok";
    }
//删除
    @GetMapping("/deleteUser")
    public String deleteUSer(){
        userMapper.deleteUser(5);
        return "ok";
    }
}

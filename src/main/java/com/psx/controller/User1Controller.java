package com.psx.controller;

import com.psx.mapper.User1Mapper;
import com.psx.pojo.User;
import com.psx.pojo.User1;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 注册登录页面
 * */



@RestController
public class User1Controller {
    @Autowired
    private User1Mapper user1Mapper;
    @RequestMapping(value = "/login.html", method = {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        user1Mapper.login("小明","root");
        return "login";
    }

//    @RequestMapping(value = "loginPage", method = {RequestMethod.POST,RequestMethod.GET})
//    public String loginCon(HttpServletRequest request, HttpSession session){
//        String username =request.getParameter("username");
//        String password = request.getParameter("password");
//        String tname = user1Mapper.login("111","2222");
//        session.setAttribute("tname",tname);
//        if (tname==null){
//            return "redirect:/";
//        }else {
//            return "redirect:/index";
//        }
//    }

    @RequestMapping(value = "loginPage")
    public ModelAndView login(User1 user1, ModelAndView mv, HttpServletRequest request, Model model){
        User1 login = user1Mapper.login(user1.getUsername(),user1.getPassword());
        System.out.println(login);
        if (login!=null){
            request.getSession().setAttribute("login",login);
            System.out.println("成功");
            mv.setViewName("index");
        }else {
            System.out.println("失败");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping(value = "/index",method = {RequestMethod.POST,RequestMethod.GET})
    public String loginindex(){
        return "/login/text";
    }


    @GetMapping("/register")
    public String save(User1 user1){
        user1Mapper.save(user1);
        return "数据已添加";
    }

}
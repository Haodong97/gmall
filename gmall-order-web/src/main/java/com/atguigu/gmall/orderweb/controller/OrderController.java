package com.atguigu.gmall.orderweb.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserInfo;

import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController {

    @Reference
    private UserService userService;

    @GetMapping("trade")
    public UserInfo trade(@RequestParam("userid") String userid){
        UserInfo userInfo = userService.getUserById(userid);

        return  userInfo;
    }

}

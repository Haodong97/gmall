package com.atguigu.gmall.usermanage.controller;


import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
     private UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("allUsers")
    public List<UserInfo> getAllUsers(){

        return userService.getUserAll();
    }

    /**
     * 根据id得到用户
     */
    @PostMapping("getUserByid/{id}")
    public UserInfo getUserByid(String id){
        return userService.getUserById(id);
    }

    /**
     * 根据id删除用户
     */
    @PostMapping("delUserById/{id}")
    public void delUserById(String id){
        userService.delUserById(id);
    }
    /**
     * 修改用户
     */
    @PostMapping("updateUser/{name}")
    public void updateUser(String name,
                           @RequestBody UserInfo userInfo){
        userService.updateUser(name,userInfo);
    }
}

package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserInfo;

import java.util.List;


public interface UserService  {
    //查询列表
    List<UserInfo> getUserAll();
    //根据id查询用户
    UserInfo getUserById(String id);
    //根据id删除用户
    void delUserById(String id);
    //根据id修改用户
    void updateUser(String name,UserInfo userInfo);

}

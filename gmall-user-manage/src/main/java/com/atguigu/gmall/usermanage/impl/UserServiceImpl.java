package com.atguigu.gmall.usermanage.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.usermanage.mapper.UserInfoMapper;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> getUserAll() {
        List<UserInfo> list = userInfoMapper.selectAll();
        return list;
    }

    @Override
    public UserInfo getUserById(String id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return userInfo;
    }

    @Override
    public void delUserById(String id) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("id",id);
        userInfoMapper.deleteByExample(example);

    }

    @Override
    public void updateUser(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);

        userInfoMapper.updateByExampleSelective(userInfo,example);

    }
}

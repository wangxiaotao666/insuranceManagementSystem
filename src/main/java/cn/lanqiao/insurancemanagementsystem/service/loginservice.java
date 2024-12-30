package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;

import java.util.List;

public interface loginservice {
    //    查询所有用户
    List<UserList> selectAll();
    //登录
    UserList findByUsername(String username);
}

package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;

public interface UserService {
    UserList findByUsername(String username);
}
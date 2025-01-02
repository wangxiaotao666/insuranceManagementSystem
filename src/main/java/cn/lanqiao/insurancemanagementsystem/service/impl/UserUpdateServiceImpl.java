package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.UserUpdateMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateServiceImpl implements UserUpdateService {

    @Autowired
    private UserUpdateMapper userUpdateMapper;

    @Override
    public UserList getUserInfo(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        return userUpdateMapper.getUserInfo(username, password);
    }

    @Override
    public void updateUserInfo(UserList userList) {
        if (userList == null || userList.getUsername() == null) {
            throw new IllegalArgumentException("User information cannot be null");
        }
        userUpdateMapper.updateUserInfo(userList);
    }
}
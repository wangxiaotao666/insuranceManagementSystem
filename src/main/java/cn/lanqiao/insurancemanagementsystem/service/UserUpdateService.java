package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.apache.ibatis.annotations.Select;

public interface UserUpdateService {
    // 根据登录时的账号和密码来拿到自己的信息
    UserList getUserInfo(String username, String password);
    //修改个人信息
    void updateUserInfo(UserList userList);
}


package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserListService{
    //查询用户信息
    List<UserList> selectUserList();

    //查询
    List<UserList> selectUser(int id);
    //根据id修改用户信息
    int updateUserList(UserList userList);

    //删除用户
    int deleteUserList(int id);
}
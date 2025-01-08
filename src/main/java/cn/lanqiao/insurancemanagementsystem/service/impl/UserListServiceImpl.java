package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.UserListMapper1;
import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    private UserListMapper1 userMapper;

    @Override
    public List<UserList> selectUserList() {
        List<UserList> userLists = userMapper.selectUserList();
        if (userLists != null) {
            //返回对象
            return userLists;
        } else {
            //
            return null;
        }

    }

    @Override
    public List<UserList> selectUser(int id) {
        List<UserList> userLists = userMapper.selectUser(id);
        if(userLists != null){
            //返回对象
            return userLists;
        }else {
            return null;
        }
    }

    @Override
    public int updateUserList(UserList userList) {
        try {
            int userLists = userMapper.updateUserList(userList);
            if (userLists > 0) {
                return 1;//操作成功
            } else {
                return 0;//操作失败
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteUserList(int id) {
        try{
            int userLists = userMapper.deleteUserList(id);
            if (userLists > 0){
                return 1;
            }else {
                return 0;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
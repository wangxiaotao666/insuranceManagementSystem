package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.PersonMapper;
import cn.lanqiao.insurancemanagementsystem.mapper.UserListMapper1;
import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonMapper PersonMapper;
    @Override
    public List<UserList> selectPerson(String name) {
        List<UserList> userLists = PersonMapper.selectPerson(name);
        if(userLists != null){
            return userLists;
        }else {
            return null;
        }
    }

    @Override
    public int updatePersonList(UserList userList) {
        try {
            int userLists = PersonMapper.updatePersonList(userList);
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

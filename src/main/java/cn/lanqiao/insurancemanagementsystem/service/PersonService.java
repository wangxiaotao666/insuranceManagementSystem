package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonService {
    //查询
    List<UserList> selectPerson(String name);
    //根据id修改用户信息
    int updatePersonList(UserList userList);
}

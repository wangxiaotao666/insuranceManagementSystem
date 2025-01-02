package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.loginmapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class loginserviceimpl implements loginservice {
    //依赖注入
    @Autowired
    private loginmapper tAdminMapper;
    @Override
    public List<UserList> selectAll() {
        List<UserList> tAdmins = tAdminMapper.selectAll();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }

    @Override
    public UserList findByUsername(String username) {
        return tAdminMapper.findByUsername(username);
    }
}

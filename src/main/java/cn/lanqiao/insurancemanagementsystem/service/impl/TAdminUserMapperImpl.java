package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.TAdminUserMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.service.TAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TAdminUserMapperImpl implements TAdminUserService {
    @Autowired
    private TAdminUserMapper tAdminUserMapper;
    @Override
    public List<ProductList> selectPList() {
        List<ProductList> tAdmins = tAdminUserMapper.selectPList();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }
}

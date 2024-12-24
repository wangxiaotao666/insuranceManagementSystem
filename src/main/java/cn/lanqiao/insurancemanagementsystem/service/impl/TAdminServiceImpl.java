package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.TAdminMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import cn.lanqiao.insurancemanagementsystem.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TAdminServiceImpl implements TAdminService {
    //依赖注入
    @Autowired
    private TAdminMapper tAdminMapper;
    @Override
    public List<TAdmin> selectAll() {
        List<TAdmin> tAdmins = tAdminMapper.selectAll();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }

    @Override
    public List<ProductList> selectPList() {
        List<ProductList> tAdmins = tAdminMapper.selectPList();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }
}

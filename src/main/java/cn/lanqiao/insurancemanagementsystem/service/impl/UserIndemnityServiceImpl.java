package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.UserIndemnityMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.service.UserIndemnityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIndemnityServiceImpl implements UserIndemnityService {

    /**
     * @return
     */
    @Autowired
    private UserIndemnityMapper userIndemnityMapper;
    @Override
    public List<OrderList> getIndemnityList() {
        System.out.println(9999);
        List<OrderList> tAdmins = userIndemnityMapper.getIndemnityList();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }
}

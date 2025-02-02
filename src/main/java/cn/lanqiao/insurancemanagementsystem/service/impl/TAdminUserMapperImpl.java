package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.TAdminUserMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.vo.OrderListVo;
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
//        System.out.println(66);
        List<ProductList> tAdmins = tAdminUserMapper.selectPList();
        if(tAdmins!=null){
            return tAdmins;
        }else{
            return null;
        }
    }

    @Override
    public Integer buyPlist(OrderListVo orderList) {
        Integer result = tAdminUserMapper.buyPlist(orderList);
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public ProductList selectNameById(String name) {
        ProductList productList = tAdminUserMapper.selectNameById(name);
        if(productList!=null){
            return productList;
        }else{
            return null;
        }
    }
}

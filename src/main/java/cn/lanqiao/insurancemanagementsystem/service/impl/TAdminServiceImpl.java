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
    public ProductList selectByName(String name) {
        ProductList result = tAdminMapper.selectByName(name);
        if(result==null){
            return null;
        }else{
            return result;
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

    @Override
    public Integer deletePList(Integer product_id) {
        Integer result = tAdminMapper.deletePList(product_id);
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Integer insertPList(ProductList productList) {
        Integer result = tAdminMapper.insertPList(productList);
        if(result>0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public int register(TAdmin tAdmin) {
        try {
            int result = tAdminMapper.register(tAdmin);
            if (result > 0){
                //添加成功
                return 1;
            }else {
                return 0;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public TAdmin selectByName1(String username) {
        TAdmin result = tAdminMapper.selectByName1(username);
        if(result==null){
            return null;
        }else{
            return result;
        }
    }
}

package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TAdminUserService {
    //   用户查询保险列表数据
    List<ProductList> selectPList();
}

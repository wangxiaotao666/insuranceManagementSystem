package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TAdminService {
    //    查询所有用户
    List<TAdmin> selectAll();
    //   查询保险列表数据
    List<ProductList> selectPList();
    //   删除保险列表功能
    Integer deletePList(Integer product_id);
}

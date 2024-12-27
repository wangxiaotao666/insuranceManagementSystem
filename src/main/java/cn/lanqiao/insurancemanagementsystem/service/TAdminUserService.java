package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.vo.OrderListVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TAdminUserService {
    //   用户查询保险列表数据
    List<ProductList> selectPList();
    //       购买保险列表功能
    Integer buyPlist(OrderListVo orderList);
}

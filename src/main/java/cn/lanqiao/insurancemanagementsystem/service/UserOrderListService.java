package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import java.util.List;

public interface UserOrderListService {
    // 获取用户订单列表
    List<OrderList> getOrderList(String username);
//
}

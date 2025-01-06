package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;

import java.util.List;

public interface UserOrderListService {
    // 获取用户订单列表
    List<OrderList> getOrderList(String userId);
//
//    // 确认支付 没有
//    boolean confirmPayment(String orderId, String productId);
//
//    // 取消订单 没有
//    boolean cancelOrder(String orderId, String productId);
}

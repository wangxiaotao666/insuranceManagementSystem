package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.UserOrderListMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.UserOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderListServiceImpl implements UserOrderListService {
    //   查询用户个人订单列表
    /**
     * @return
     */
    @Autowired
    private UserOrderListMapper userOrderListMapper;
    @Override
    public List<OrderList> getOrderList(String username) {
        try {
            // 直接使用用户名查询订单  111
            return userOrderListMapper.getOrderList(username);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//状态
//    @Override
//    public boolean confirmPayment(String orderId, String productId) {
//        try {
//            int result = userOrderListMapper.updateOrderState(orderId, productId, "1");
//            return result > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//操作
//    @Override
//    public boolean cancelOrder(String orderId, String productId) {
//        try {
//            int result = userOrderListMapper.deleteOrder(orderId, productId);
//            return result > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}


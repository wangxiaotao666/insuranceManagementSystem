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
    public List<OrderList> getIndemnityList(String name) {
//        System.out.println(9999);
        try {
            // 直接使用用户名查询订单  111
            return userIndemnityMapper.getIndemnityList(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override

    public boolean applyPayment(String orderId, String productId) {

        try {

            // 更新订单状态为申请赔付（状态码2）

            int result = userIndemnityMapper.updateOrderState(orderId, productId);

            return result > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }
}

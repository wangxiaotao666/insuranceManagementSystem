package cn.lanqiao.insurancemanagementsystem.service.impl;

import cn.lanqiao.insurancemanagementsystem.mapper.OrderListMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.OrderListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-23
 */
@Service
public class OrderListServiceImpl  implements OrderListService {
    @Autowired
//    1
    private OrderListMapper OrderListMapper;
    @Override
    public List<OrderList> getorderlist() {
        List<OrderList> orderLists = OrderListMapper.getorderlist();
        if(orderLists!=null){
            return orderLists;
        }else {
            return null;
        }
    }
}


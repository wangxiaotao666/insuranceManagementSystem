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
        if (orderLists != null) {
            return orderLists;
        } else {
            return null;
        }
    }

    @Override
    public List<OrderList> getcompensationlist() {
        List<OrderList> compensationlists = OrderListMapper.getcompensationlist();
        if (compensationlists != null) {
            return compensationlists;
        } else {
            return null;
        }
    }

    @Override
    public int agreeCompensation(OrderList orderList) {
        int agreeCompensation = OrderListMapper.agreeCompensation(orderList);
        if ( agreeCompensation > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public int disagreeCompensation(OrderList orderList) {
        int i = OrderListMapper.disagreeCompensation(orderList);
        if (i>0) {
            return 1;
        } else {
            return 0;
        }
    }
}
package cn.lanqiao.insurancemanagementsystem.service;


import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author author
 * @since 2024-12-23
 */
public interface TAdminOrderListService {
    List<OrderList> getorderlist();
//查询赔偿申请列表
   List<OrderList> getcompensationlist();
    // 同意赔付申请
    int agreeCompensation(OrderList orderList);

    // 拒绝赔付申请
    int disagreeCompensation(OrderList orderList);
}


package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import java.util.List;

public interface UserIndemnityService {
    //   查询个人申请赔偿列表1
    List<OrderList> getIndemnityList(String name);

    // 添加申请赔付方法
    boolean applyPayment(String orderId, String productId);

}

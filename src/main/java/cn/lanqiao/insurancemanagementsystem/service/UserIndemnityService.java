package cn.lanqiao.insurancemanagementsystem.service;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;


import java.util.List;

public interface UserIndemnityService {
    //   查询个人申请赔偿列表
    List<OrderList> getIndemnityList();
}

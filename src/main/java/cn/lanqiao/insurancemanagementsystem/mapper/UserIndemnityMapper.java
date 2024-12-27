package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserIndemnityMapper {
    //   查询个人申请赔偿列表
    @Select("select * from order_list ")
    List<OrderList> getIndemnityList();
}

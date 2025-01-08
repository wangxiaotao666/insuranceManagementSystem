package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserOrderListMapper {
    // 获取用户订单列表  根据user_list表中的username （这个在cookie里拿，）来查order_list表中的数据
    @Select("select * from order_list where order_uname = #{name}")
    List<OrderList> getOrderList(String name);


}

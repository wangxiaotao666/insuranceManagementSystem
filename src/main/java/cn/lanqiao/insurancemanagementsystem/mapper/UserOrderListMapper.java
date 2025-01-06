package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserOrderListMapper {
    // 获取用户订单列表  根据user_list表中的username来查order_list表中的数据
    @Select("select * from order_list where order_uname = #{name}")
    List<OrderList> getOrderList(String name);

//    // 更新订单状态
//    @Update("update order_list set order_state = #{state} where order_id = #{orderId} and product_id = #{productId}")
//    int updateOrderState(String orderId, String productId, String state);
//
//    // 删除订单 没有
//    @Delete("delete from order_list where order_id = #{orderId} and product_id = #{productId}")
//    int deleteOrder(String orderId, String productId);

}

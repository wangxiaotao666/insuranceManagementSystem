package cn.lanqiao.insurancemanagementsystem.mapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserIndemnityMapper {
    //   查询个人申请赔偿列表111
    @Select("select * from order_list where order_uname = #{name}")
    List<OrderList> getIndemnityList(String name);
    // 更新订单状态为申请赔付

    @Update("update order_list set order_state = '2' where order_id = #{orderId} and product_id = #{productId}")

    int updateOrderState(String orderId, String productId);
}

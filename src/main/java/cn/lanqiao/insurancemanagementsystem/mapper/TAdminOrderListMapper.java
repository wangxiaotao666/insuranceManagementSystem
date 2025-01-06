package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-12-23
 */
public interface TAdminOrderListMapper {
    //订单列表11
    //查询订单列表
    @Select("select * from order_list ")
    List<OrderList> getorderlist();
    //查询赔偿申请列表
    @Select("select * from order_list ")
    List<OrderList> getcompensationlist();
    // 设置订单状态为已赔付（9）
    @Update("update order_list set order_state = 9 where order_id = #{order_id}")
    int agreeCompensation(OrderList orderList);

    // 拒绝赔付申请
    @Update("update order_list set order_state = 'n' where order_id = #{order_id}")
    int disagreeCompensation(OrderList orderList);

}
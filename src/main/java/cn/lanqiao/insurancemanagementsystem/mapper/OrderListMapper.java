package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-12-23
 */
public interface OrderListMapper  {
    //订单列表


   //查询订单列表

    @Select("select * from order_list ")
    List<OrderList> getorderlist();

}

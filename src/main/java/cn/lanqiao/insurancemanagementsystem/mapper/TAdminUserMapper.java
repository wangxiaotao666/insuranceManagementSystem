package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.vo.OrderListVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface TAdminUserMapper {
    //   用户查询保险列表数据
    @Select("select * from product_list where is_delete=0")
    List<ProductList> selectPList();
//       购买保险列表功能
    @Insert("insert into order_list values(null,#{order_name},#{order_cost},#{order_time},#{name},2,1,#{product_id})")
    Integer buyPlist(OrderListVo orderList);
//      根据保险名查询保险id
    @Select("select * from product_list where is_delete = 0 and product_name =#{product_name}")
    ProductList selectNameById(String name);

}

package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TAdminUserMapper {
    //   用户查询保险列表数据
    @Select("select * from product_list where is_delete=0")
    List<ProductList> selectPList();
//       购买保险列表功能
    @Insert("insert into order_list values(null,'order_name',222222,1111111,'用户1',2,'n',2)")
    Integer buyPlist(OrderList orderList);

}

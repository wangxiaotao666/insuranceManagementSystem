package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TAdminMapper {
//    根据姓名查询用户1
    @Select("select * from product_list where product_name = #{product_name} and is_delete=0")
    ProductList selectByName(String product_name);
//   查询保险列表数据
    @Select("select * from product_list where is_delete=0")
    List<ProductList> selectPList();
//   删除保险列表功能
    @Update("update product_list set is_delete = 1 where product_id=#{product_id}")
    Integer deletePList(Integer product_id);
//    新增保险列表功能
    @Insert("insert into product_list values(null,#{product_name},#{product_desc},#{product_cost},#{product_time},0)")
    Integer insertPList(ProductList productList);
    /**
     * 注册功能
     */
    @Insert("insert into user_list values (null,#{username},#{password},#{nickname},#{sex},#{age},#{phone},#{address},0,0)")
    int register(TAdmin tAdmin);
    //注册查询用户名是否重复
    @Select("select * from user_list where username = #{username} ")
    TAdmin selectByName1(String username);
}

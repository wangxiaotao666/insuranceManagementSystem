package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TAdminMapper {
//    查询所有用户
    @Select("select * from t_admin where is_delete=0")
    List<TAdmin> selectAll();
//   查询保险列表数据
    @Select("select * from product_list where is_delete=0")
    List<ProductList> selectPList();
//   删除保险列表功能
    @Update("update product_list set is_delete = 1 where product_id=#{product_id}")
    Integer deletePList(Integer product_id);

}

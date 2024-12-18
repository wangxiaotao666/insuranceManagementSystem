package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TAdminMapper {
//    查询所有用户
    @Select("select * from t_admin where is_delete=0")
    List<TAdmin> selectAll();
}

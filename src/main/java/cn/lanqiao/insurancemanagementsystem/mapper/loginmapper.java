package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface loginmapper {
    List<UserList> selectAll();

    //登录
    @Select("SELECT * FROM user_list WHERE username = #{username}")
    UserList findByUsername(@Param("username") String username);
}
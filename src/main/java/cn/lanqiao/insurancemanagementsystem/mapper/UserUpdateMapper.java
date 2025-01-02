package cn.lanqiao.insurancemanagementsystem.mapper;



import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;

import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;



public interface UserUpdateMapper {

    // 根据登录时的账号和密码来拿到自己的信息

    @Select("select * from user_list where username=#{username} and password=#{password}")

    UserList getUserInfo(String username, String password);

    //修改个人信息

    @Update("update user_list set password=#{password}, name=#{name}, sex=#{sex}, " +

            "age=#{age}, phone=#{phone}, address=#{address} where username=#{username}")

    void updateUserInfo(UserList userList);

}



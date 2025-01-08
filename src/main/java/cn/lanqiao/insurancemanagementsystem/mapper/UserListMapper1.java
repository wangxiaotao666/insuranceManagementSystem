package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserListMapper1 {
    //查询用户信息
    @Select("select * from user_list where is_delete = 0")
    List<UserList> selectUserList();
    //查询
    @Select("select * from user_list where user_id = #{id}")
    List<UserList> selectUser(int id);
    //根据id修改用户信息
    @Update("update user_list set username=#{username} , password=#{password},name=#{name}, sex=#{sex} , age=#{age} , phone=#{phone} , address=#{address}  where user_id= #{user_id}")
    int updateUserList(UserList userList);

    //删除用户
    @Update("update user_list set is_delete = 1 where user_id = #{id}")
    int deleteUserList(int id);
}
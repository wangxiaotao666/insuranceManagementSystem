package cn.lanqiao.insurancemanagementsystem.mapper;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PersonMapper {
    //查询
    @Select("select * from user_list where name=#{name}")
    List<UserList> selectPerson(String name);

    //根据id修改用户信息
    @Update("update user_list set username=#{username} , password=#{password},name=#{name}, sex=#{sex} , age=#{age} , phone=#{phone} , address=#{address}  where user_id= #{user_id}")
    int updatePersonList(UserList userList);
}

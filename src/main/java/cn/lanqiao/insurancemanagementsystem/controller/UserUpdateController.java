package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserUpdateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userUpdate")
@CrossOrigin  // 添加跨域支持
public class UserUpdateController {
    @Autowired
    private UserUpdateServiceImpl userUpdateService;

    // 获取用户信息
    @GetMapping("/getUserInfo")  // 改为 GET 方法
    public UserList getUserInfo(@RequestParam String username, @RequestParam String password) {
        //用户修改信息   (根据用户登录的账号名和密码来修改）
        //先拿到用户自己的信息
        return userUpdateService.getUserInfo(username, password);
    }

    // 更新用户信息
    @PostMapping("/updateUserInfo")  // 明确使用 POST 方法
    public void updateUserInfo(@RequestBody UserList userList) {  // 添加 @RequestBody 注解
        userUpdateService.updateUserInfo(userList);
    }


}
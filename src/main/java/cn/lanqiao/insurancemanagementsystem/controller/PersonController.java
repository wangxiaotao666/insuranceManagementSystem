package cn.lanqiao.insurancemanagementsystem.controller;


import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.PersonService;
import cn.lanqiao.insurancemanagementsystem.service.impl.PersonServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PersonController")
public class PersonController {
    @Autowired
    private PersonService PersonService;

    //提交用户信息
    @RequestMapping("/selectPerson")
    public ResponseUtils selectPerson(HttpServletRequest request){
//        利用cookie获取按钮的值
        try {
            String name = null;
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("name")) {
                    name = cookies[i].getValue();
                    break;
                }
            }
//            将字符串强转int类型
            List<UserList> userLists = PersonService.selectPerson(name);
            if (userLists != null){
                return new ResponseUtils(200,"查询成功",userLists);
            }else {
                return new ResponseUtils(500,"查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseUtils(400,"查询异常");
        }
    }
    //根据id修改用户信息
    @RequestMapping("/updatePersonList")
    public ResponseUtils updatePersonList(@RequestBody UserList userList){
        try {
            //接口
            System.out.println(userList);
            int userLists = PersonService.updatePersonList(userList);
            if (userLists == 1){
                return new ResponseUtils(200,"修改成功");
            }else {
                return new ResponseUtils(500,"修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseUtils(400,"修改异常");
        }
    }
}

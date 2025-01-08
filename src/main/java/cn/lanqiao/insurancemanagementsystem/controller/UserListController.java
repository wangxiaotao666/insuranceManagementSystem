package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.UserList;
import cn.lanqiao.insurancemanagementsystem.service.UserService;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserListServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UserListController")
public class UserListController {
    @Autowired
    private UserListServiceImpl userListService;
    //查询用户信息
    @RequestMapping("/selectUserList")
    public ResponseUtils selectUserList() {
        try {
            List<UserList> userLists = userListService.selectUserList();
//            System.out.println(userLists);
            if (userLists != null) {
                return new ResponseUtils(200, "查询成功", userLists);
            } else {
                return new ResponseUtils(500, "查询失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseUtils(400,"查询异常");
        }
    }
    //    获取修改按钮的数据
    @RequestMapping("/findID")
    public void findID(@RequestBody UserList userList, HttpServletResponse response){
        Cookie cookie = new Cookie("updateBtn",String.valueOf(userList.getUser_id()));
        // 设置cookie的存活时间123
        cookie.setMaxAge(60 * 60 * 24);
        // 设置cookie的路径，使其在整个应用中可用
        cookie.setPath("/");
        response.addCookie(cookie);

    }
    //修改查询
    @RequestMapping("/selectUser")
    public ResponseUtils selectUser(HttpServletRequest request){
//        利用cookie获取按钮的值
        try {
            String btn = null;
            Cookie[] cookies = request.getCookies();
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("updateBtn")) {
                    btn = cookies[i].getValue();
                    break;
                }
            }
//            将字符串强转int类型
            int btnU = Integer.parseInt(btn);
            List<UserList> userLists = userListService.selectUser(btnU);
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
    @RequestMapping("/updateUserList")
    public ResponseUtils updateUserList(@RequestBody UserList userList){
        try {
            //接口
            System.out.println(userList);
            int userLists = userListService.updateUserList(userList);
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
    //删除用户
    @RequestMapping("/deleteUserList")
    public ResponseUtils deleteUserList(@RequestBody UserList userLogin){
        try{
            int userLists = userListService.deleteUserList(userLogin.getUser_id());
            if (userLists == 1){
                return new ResponseUtils(200,"删除成功");
            }else {
                return new ResponseUtils(500,"删除失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseUtils(400,"删除异常");
        }
    }

}
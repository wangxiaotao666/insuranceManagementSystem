package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserOrderListServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/userOrderList")
@CrossOrigin
public class UserOrderListController {
    //用户个人订单列表
    //依赖注入
    @Autowired
    UserOrderListServiceImpl userOrderListService;
    @RequestMapping("/getOrderList")//映射
    public ResponseUtils getList(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                System.out.println("没有找到任何cookie");
                return new ResponseUtils(401, "请先登录");
            }
            String name = null;
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())) {
                    name = cookie.getValue();
                    break;
                }
            }
            if (name == null) {
                System.out.println("没有找到name cookie");
                return new ResponseUtils(401, "请先登录");
            }
            List<OrderList> list = userOrderListService.getOrderList(name);
            if (list != null) {
                return new ResponseUtils(200, "查询成功", list);
            } else {
                System.out.println("查询失败");
                return new ResponseUtils(500, "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "查询异常: " + e.getMessage());
        }
    }
//
}
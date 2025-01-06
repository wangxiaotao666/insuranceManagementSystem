package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserOrderListServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userOrderList")
@CrossOrigin
public class UserOrderListController {
    //用户个人订单列表
    @Autowired
    UserOrderListServiceImpl userOrderListService;
    @RequestMapping("/getOrderList")
    public ResponseUtils getList(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            
            if (cookies == null) {
                System.out.println("没有找到任何cookie");
                return new ResponseUtils(401, "请先登录");
            }

//            String username = null;
            String name = null;
            for (Cookie cookie : cookies) {
//                System.out.println("发现cookie: " + cookie.getName() + "=" + cookie.getValue());
                if ("name".equals(cookie.getName())) {
                    name = cookie.getValue();
                    break;
                }
            }

            if (name == null) {
                System.out.println("没有找到name cookie");
                return new ResponseUtils(401, "请先登录");
            }

//            System.out.println("使用用户名查询订单: " + name);
            List<OrderList> list = userOrderListService.getOrderList(name);
            
            if (list != null) {
//                System.out.println("查询成功，找到 " + list.size() + " 条订单");
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
//    @PostMapping("/confirmPayment")
//    public ResponseUtils confirmPayment(@RequestBody Map<String, String> params) {
//        try {
//            String orderId = params.get("order_id");
//            String productId = params.get("product_id");
//            boolean success = userOrderListService.confirmPayment(orderId, productId);
//
//            if (success) {
//                return new ResponseUtils(200, "支付成功");
//            } else {
//                return new ResponseUtils(500, "支付失败");
//            }
//        } catch (Exception e) {
//            return new ResponseUtils(400, "支付处理异常: " + e.getMessage());
//        }
//    }

//    @PostMapping("/cancelOrder")
//    public ResponseUtils cancelOrder(@RequestBody Map<String, String> params) {
//        try {
//            String orderId = params.get("order_id");
//            String productId = params.get("product_id");
//            boolean success = userOrderListService.cancelOrder(orderId, productId);
//
//            if (success) {
//                return new ResponseUtils(200, "订单取消成功");
//            } else {
//                return new ResponseUtils(500, "订单取消失败");
//            }
//        } catch (Exception e) {
//            return new ResponseUtils(400, "订单取消异常: " + e.getMessage());
//        }
//    }
}
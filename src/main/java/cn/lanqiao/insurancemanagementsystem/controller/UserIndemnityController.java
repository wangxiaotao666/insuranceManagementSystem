package cn.lanqiao.insurancemanagementsystem.controller;


import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserIndemnityServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userIndemnity")
public class UserIndemnityController {
    //个人申请赔偿列表
    @Autowired
    UserIndemnityServiceImpl userIndemnityService;
    @RequestMapping("/getList")
    public ResponseUtils getUserOrderList(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
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
                return new ResponseUtils(401, "请先登录");
            }
            List<OrderList> list = userIndemnityService.getIndemnityList(name);
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
    @PostMapping("/applyPayment")
    public ResponseUtils applyPayment(@RequestBody Map<String, String> params) {
        try {
            String orderId = params.get("order_id");
            String productId = params.get("product_id");

            // 调用服务层处理申请
            boolean success = userIndemnityService.applyPayment(orderId, productId);

            if (success) {
                return new ResponseUtils(200, "申请提交成功");
            } else {
                return new ResponseUtils(500, "申请提交失败");
            }
        } catch (Exception e) {
            return new ResponseUtils(400, "申请处理异常: " + e.getMessage());
        }
    }
}

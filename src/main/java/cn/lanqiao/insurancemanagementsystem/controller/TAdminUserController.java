package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.vo.OrderListVo;
import cn.lanqiao.insurancemanagementsystem.service.impl.TAdminUserMapperImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tAdminUser")
public class TAdminUserController {
    //    依赖注入

    @Autowired
    private TAdminUserMapperImpl tAdminUserMapper;
    //    查找所有保险表格信息
    @RequestMapping("/selectPList")
    public ResponseUtils selectAllPl() {
        try {
            List<ProductList> productLists = tAdminUserMapper.selectPList();
            if(productLists==null){
                return new ResponseUtils(500,"数据查询失败");
            }else {
                return new ResponseUtils(200,"数据查询成功",productLists);
            }
        } catch (Exception e) {
            return new ResponseUtils(400,"数据查询异常");
        }
    }
    @RequestMapping("/buyPlist")
    public ResponseUtils buyPlist(@RequestBody OrderListVo orderList, HttpServletRequest request,HttpServletResponse response){
        try {
            String name = null;
            //获取Cookie对象
            Cookie[] cookies = request.getCookies();
            //获取Cookie中的数据
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("name")) {
                    name = cookies[i].getValue();
                    break;
                }
            }
            orderList.setName(name);
        //      根据保险名查询保险id
            ProductList productList = tAdminUserMapper.selectNameById(orderList.getOrder_name());
//            将查询到的赋值
            orderList.setProduct_id(productList.getProduct_id());
            Integer result = tAdminUserMapper.buyPlist(orderList);
            if(result==1){
                return new ResponseUtils(200,"购买成功");
            }else{
                return new ResponseUtils(500,"购买失败");
            }
        } catch (Exception e) {
            return new ResponseUtils(400,"购买异常");
        }
    }
}

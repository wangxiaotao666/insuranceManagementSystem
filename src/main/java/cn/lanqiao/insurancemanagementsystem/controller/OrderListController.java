package cn.lanqiao.insurancemanagementsystem.controller;


import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.impl.OrderListServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-12-23
 */
@RestController
@RequestMapping("/orderlist")
public class OrderListController {
    @Autowired
    private OrderListServiceImpl orderListService;
    @RequestMapping("/getOrderList")
    public ResponseUtils getOrderList(){
        try{
        List<OrderList> orderLists = orderListService.getorderlist();
        if (orderLists ==null){
            //查询为空(失败)
            return new ResponseUtils(500,"查询失败");
        }else {
            //查询成功
            return new ResponseUtils(200,"查询成功",orderLists);
        }
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseUtils(400,"管理员查询异常");}

    }
    //查询赔偿申请列表
    @RequestMapping("/getCompensationList")
    public ResponseUtils getCompensationList() {
        try {
            List<OrderList> compensations = orderListService.getcompensationlist();
            if (compensations == null) {
                //查询为空(失败)
                return new ResponseUtils(500, "查询失败");
            } else {
                //查询成功
                return new ResponseUtils(200, "查询成功", compensations);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseUtils(400, "管理员查询异常");
        }
    }
    @PostMapping("/agreeCompensation")
public ResponseUtils agreeCompensation(@RequestBody OrderList orderList) {
    try {
        int result = orderListService.agreeCompensation(orderList);
        if (result > 0) {
            return new ResponseUtils(200, "赔付申请已同意");
        } else {
            return new ResponseUtils(500, "操作失败");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseUtils(400, "处理异常");
    }
}
@RequestMapping("/disagreeCompensation")
public ResponseUtils disagreeCompensation(@RequestBody OrderList orderList) {
    try {
        int result = orderListService.disagreeCompensation(orderList);
        if (result > 0) {
            return new ResponseUtils(200, "赔付申请已拒绝");
        } else {
            return new ResponseUtils(500, "操作失败");
        }
    } catch (Exception e) {
        e.printStackTrace();
        return new ResponseUtils(400, "处理异常");
    }
}
}

package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.mapper.UserIndemnityMapper;
import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.service.impl.UserIndemnityServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userIndemnity")
public class UserIndemnityController {
    //个人申请赔偿列表
    @Autowired
    UserIndemnityServiceImpl userIndemnityService;
    @RequestMapping("/getList")
    public ResponseUtils getList(){
        try {
            List<OrderList> list=userIndemnityService.getIndemnityList();
            if (list==null){
                return new ResponseUtils(500,"数据查询失败");
            }else {
                return new ResponseUtils(200,"数据查询成功",list);
            }
        } catch (Exception e) {
            return new ResponseUtils(400,"数据查询异常");
        }
    }
}

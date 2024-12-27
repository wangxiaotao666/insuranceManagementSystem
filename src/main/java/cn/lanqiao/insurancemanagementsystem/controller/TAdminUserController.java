package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.OrderList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.service.impl.TAdminUserMapperImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseUtils buyPlist(@RequestBody OrderList orderList){
        try {
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

package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import cn.lanqiao.insurancemanagementsystem.service.TAdminService;
import cn.lanqiao.insurancemanagementsystem.service.impl.TAdminServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tAdmin")
public class TAdminController {
//    依赖注入

    @Autowired
    private TAdminServiceImpl tAdminService;
    @RequestMapping("/select")
    public void selectAllTUser() {
        List<TAdmin> tAdmins = tAdminService.selectAll();
    }
    @RequestMapping("/selectPList")
    public ResponseUtils selectAllPl() {
        try {
            List<ProductList> productLists = tAdminService.selectPList();
            if(productLists==null){
                System.out.println(0);
                return new ResponseUtils(500,"数据查询失败");
            }else {
                System.out.println(1);
                return new ResponseUtils(200,"数据查询成功",productLists);
            }
        } catch (Exception e) {

            return new ResponseUtils(500,"数据查询异常");
        }

    }

}

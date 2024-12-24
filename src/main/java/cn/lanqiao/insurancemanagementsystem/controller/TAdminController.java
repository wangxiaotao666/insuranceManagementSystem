package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import cn.lanqiao.insurancemanagementsystem.service.TAdminService;
import cn.lanqiao.insurancemanagementsystem.service.impl.TAdminServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
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
                return new ResponseUtils(500,"数据查询失败");
            }else {
                return new ResponseUtils(200,"数据查询成功",productLists);
            }
        } catch (Exception e) {
            return new ResponseUtils(400,"数据查询异常");
        }
    }
    @RequestMapping("/deletePList")
    public ResponseUtils deletePList(@RequestBody ProductList plt){
        Integer product_id = plt.getProduct_id();
        try {
            int result = tAdminService.deletePList(product_id);
            if(result==1){
                return new ResponseUtils(200,"数据删除成功");
            }else{
                return new ResponseUtils(500,"数据删除失败");
            }
        } catch (Exception e) {
            return new ResponseUtils(400,"操作异常");
        }

    }

}

package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.ProductList;
import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import cn.lanqiao.insurancemanagementsystem.service.TAdminService;
import cn.lanqiao.insurancemanagementsystem.service.impl.TAdminServiceImpl;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
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
//    查找所有保险表格信息
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
//    删除指定保险表格
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
//    新增保险表格
    @RequestMapping("/insertPList")
    public ResponseUtils insertPList(@RequestBody ProductList plt){
//        如果用户没有输入数据或者数据没有输入完整，数据就不能添加数据库中
        if(plt.getProduct_name()!="" && plt.getProduct_cost()!="" && plt.getProduct_desc()!=""){
//            判断是保险名字是否存在，存在就不添加，不存在就添加
            ProductList tAdmins = tAdminService.selectByName(plt.getProduct_name());
            if(tAdmins==null){
                try {
                    Integer result = tAdminService.insertPList(plt);
                    if(result==1){
                        return new ResponseUtils(200,"数据添加成功");
                    }else{
                        return new ResponseUtils(500,"数据添加失败");
                    }
                } catch (Exception e) {
                    return new ResponseUtils(400,"操作异常");
                }
            }else {
                return new ResponseUtils(306,"名字已经拥有");
            }

        }else {
            return new ResponseUtils(305,"没有数据");
        }
    }
    @PostMapping("/register")
    public ResponseUtils register(@RequestBody TAdmin tAdmin) {
//        // 直接进行注册操作
//        int result = tAdminService.register(tAdmin);
//
//        // 如果 result == 1 表示注册成功，否则注册失败
//        return (result == 1)
//                ? new ResponseUtils(200, "注册成功")
//                : new ResponseUtils(500, "注册失败");
//    }
        if(tAdmin.getUsername()!="" && tAdmin.getPassword()!="" && tAdmin.getNickname()!="" && tAdmin.getAge()!=""&& tAdmin.getPhone()!=""&& tAdmin.getAddress()!=""){
//            判断是用户名名字是否存在，存在就不添加，不存在就添加
            TAdmin tAdmin1 = tAdminService.selectByName1(tAdmin.getUsername());
            if(tAdmin1==null){
                try {
                    int register = tAdminService.register(tAdmin);
                    if(register==1){
                        return new ResponseUtils(200,"数据添加成功");
                    }else{
                        return new ResponseUtils(306,"数据添加失败");
                    }
                } catch (Exception e) {
                    return new ResponseUtils(400,"操作异常");
                }
            }else {
                return new ResponseUtils(306,"名字已经拥有");
            }

        }else {
            return new ResponseUtils(305,"没有数据");
        }
    }
}

package cn.lanqiao.insurancemanagementsystem.controller;

import cn.lanqiao.insurancemanagementsystem.model.pojo.TAdmin;
import cn.lanqiao.insurancemanagementsystem.service.TAdminService;
import cn.lanqiao.insurancemanagementsystem.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tAdmin")
public class TAdminController {
//    依赖注入
//sdakd
    @Autowired
    private TAdminService tAdminService;
    @RequestMapping("/select")
    public void selectAllTUser() {
        List<TAdmin> tAdmins = tAdminService.selectAll();
        //aaa
    }
}

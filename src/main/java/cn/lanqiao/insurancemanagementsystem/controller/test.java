package cn.lanqiao.insurancemanagementsystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
//    测试用
    @RequestMapping("/t")
    public String demo(){
        return "hello";
    }
}

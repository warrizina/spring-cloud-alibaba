package com.datatsource.cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/8/5 19:03
 * @author: wzd
 */
@RestController
public class TestContoller {

    @RequestMapping("/")
    public String aop(){
        System.out.println("执行方法");
        return null;
    }

}

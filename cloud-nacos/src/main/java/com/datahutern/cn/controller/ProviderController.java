package com.datahutern.cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/8/3 11:33
 * @author: wzd
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "forezp",required = false) String name) {
        return "hello " + name + ", i'm provider ,my port:" + port;

    }

}

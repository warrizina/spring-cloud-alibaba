package com.datahunter.cn.controller;

import com.datahunter.cn.customer.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2021/8/3 13:42
 * @author: wzd
 */
@RestController
public class CustomerController {

    @Autowired
    private ProviderClient providerClient;

    @GetMapping("/hiFeign")
    public String hiFeign(){
        return providerClient.hi("hi feign");
    }
}

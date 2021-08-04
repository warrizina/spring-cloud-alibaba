package com.datahunter.cn.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @date: 2021/8/3 13:40
 * @author: wzd
 */

/**
 *如果服务提供方已经注册到注册中心了，那么name或者value的值为：服务提供方的服务名称。必须为所有客户端指定一个name或者value
 */
@FeignClient(value = "provider")
public interface ProviderClient {


    @GetMapping("/hi")
    String hi(@RequestParam(value = "name", defaultValue = "forezp", required = false) String name);
}

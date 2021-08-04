package com.datahutern.cn;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;






@SpringBootApplication
// 让注册中心可以发现扫描到该服务
@EnableDiscoveryClient
public class CloudNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudNacosApplication.class, args);
    }

}

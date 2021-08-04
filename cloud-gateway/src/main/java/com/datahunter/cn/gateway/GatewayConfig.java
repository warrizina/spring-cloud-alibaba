package com.datahunter.cn.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2021/8/4 15:58
 * @author: 恒利
 */
@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("Hello", "World"))
//                        .uri("http://httpbin.org:80"))
//                .route(p -> p
//                        .host("*.hystrix.com","localhost:9092")
//                        .filters(f -> f.hystrix(config ->
//                                config.setName("mycmd")
//                                .setFallbackUri("forward:/fallback")))
//                        .uri("http://httpbin.org:80")).
//                        build();
//    }

    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route("",predicateSpec -> {
                    predicateSpec.cookie("","");
                    predicateSpec.uri("");
                    predicateSpec.header("");
                    predicateSpec.path("");

                    return null;
                }).build();
    }
}

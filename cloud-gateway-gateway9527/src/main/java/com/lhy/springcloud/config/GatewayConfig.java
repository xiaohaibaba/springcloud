package com.lhy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/05/30 15:53
 */
@Configuration
public class GatewayConfig {
    /**
     * 配置一个route-name的路由规则
     * 当访问http://localhost:9527/guonei时自动转发到指定的地址
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_lhy",
                r -> r.path("china")
                        .uri("https://blog.csdn.net/weixin_42033269/article/details/89877662")).build();
        return routes.build();
    }
}

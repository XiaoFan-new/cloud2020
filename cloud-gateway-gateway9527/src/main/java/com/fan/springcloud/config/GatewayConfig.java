package com.fan.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by fan
 * on 2020/5/15 12:50
 */
@Configuration
public class GatewayConfig {
    /**
     *  配置一个id为path_route_fan的路由规则
     *  当访问http://localhost:9527/fan时，会自动转发到地址：https://github.com/
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        return routes.route("path_route_fan",
                a ->a.path("/fan")
                        .uri("https://github.com/")).build();
    }
}


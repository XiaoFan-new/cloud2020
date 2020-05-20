package com.fan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Create by fan
 * on 2020/5/16 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderDemoApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderDemoApplication9001.class, args);
    }
}

package com.fan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Create by fan
 * on 2020/5/20 15:52
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
@EnableDiscoveryClient
@EnableFeignClients
public class SeataStrorageMainApp2002 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStrorageMainApp2002.class,args);
    }
}

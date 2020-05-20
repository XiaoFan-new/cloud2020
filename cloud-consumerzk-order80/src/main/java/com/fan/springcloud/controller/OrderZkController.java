package com.fan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Create by fan
 * on 2020/5/12 20:54
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL="http://cloud-provider-payment";
    @Resource //java自带的注解注入
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String payment(){
        String s = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        return s;
    }

}

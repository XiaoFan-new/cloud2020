package com.fan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Create by fan
 * on 2020/5/13 13:41
 */
@RestController
@Slf4j
public class PaymentController {
    //获取端口号
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentConsul()
    {
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

package com.fan.springcloud.controller;

import com.fan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by fan
 * on 2020/5/14 14:37
 */
@RestController
@Slf4j
public class paymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String sreverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymnetInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymnetInfo_OK(id);
        log.info("*****result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:"+result);
        return result;
    }
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("************result:"+result);
        return result;
    }
}

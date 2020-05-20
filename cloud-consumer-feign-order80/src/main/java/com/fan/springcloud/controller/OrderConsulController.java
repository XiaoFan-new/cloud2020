package com.fan.springcloud.controller;

import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by fan
 * on 2020/5/14 10:26
 */
@RestController
@Slf4j
public class OrderConsulController {

    @Resource
    private PaymentFeignService paymentFeignService;
    //如果返回的是XML格式，可以在后方加：@GetMapping(value = "/consumer/payment/get/{id}",produces = "application/json")
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}

package com.fan.springcloud.service;

import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Create by fan
 * on 2020/5/14 10:23
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //拉取Controller层
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id);

    //拉取service层
    /*public Payment getPaymentById(@Param("id") Long id);*/

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}

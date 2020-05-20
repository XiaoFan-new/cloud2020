package com.fan.springcloud.controller;

import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort; //端口号

    @Resource
    private PaymentService paymentService;

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果"+result);
        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败,serverPort:"+serverPort,null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********插入结果"+payment);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id+"serverPort:"+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}

package com.fan.springcloud.controller;

import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Create by fan
 * on 2020/5/19 11:40
 */
@RestController
public class paymentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    //静态代码块
    static {
        hashMap.put(1L,new Payment(1L,"cfo5xqo2cqnuccy12hd6"));
        hashMap.put(2L,new Payment(2L,"eurh6cs1t2s5bg6rrffq"));
        hashMap.put(3L,new Payment(3L,"78ewkjd2jijxvbtrdmjh"));
    }
    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mySql：" + serverPort,payment);
        return result;
    }


}

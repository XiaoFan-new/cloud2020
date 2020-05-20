package com.fan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Create by fan
 * on 2020/5/16 17:42
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback")//没有配置的
    //@SentinelResource(value = "fallback",fallback = "handFallback")
    //@SentinelResource(value = "fallback",blockHandler = "handFallback")
    @SentinelResource(value = "fallback",blockHandler = "blockFallback",fallback = "handFallback")
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(serverURL + "/paymentSQL/" + id, CommonResult.class);
        if (id==4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常......");
        }else if (result.getDate()==null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
    //fallback
    public CommonResult handFallback(@PathVariable Long id, Throwable e){
        Payment payment = new Payment(id, null);
        return new CommonResult(444,"兜底异常handFallback，BlockException内容："+e.getMessage(),payment);

    }

    //blockHandler
    public CommonResult blockFallback(@PathVariable Long id, BlockException e){
        Payment payment = new Payment(id, null);
        return new CommonResult(445,"blockHandler-sentinel限流，无此流水，BlockException内容："+e.getMessage(),payment);

    }

    //=======================================OpenFeign
    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }

}

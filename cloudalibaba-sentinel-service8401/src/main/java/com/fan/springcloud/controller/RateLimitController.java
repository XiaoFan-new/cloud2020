package com.fan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fan.springcloud.entities.CommonResult;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by fan
 * on 2020/5/18 16:18
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020L,"serial001"));
    }
    public CommonResult deal_byResource(BlockException e){
        return new CommonResult(444,e.getClass().getName()+": 服务不可用");
    }


    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public CommonResult CustomerBlockHandler()
    {
        return new CommonResult(200,"按客户自定义处理",new Payment(2020L,"serial002"));
    }


}

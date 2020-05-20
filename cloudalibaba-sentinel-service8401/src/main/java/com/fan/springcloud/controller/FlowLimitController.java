package com.fan.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Create by fan
 * on 2020/5/18 10:28
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "*********testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"*******testB");
        return "*********testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("TestD测试RT");
        return "********testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("TestE异常数测试");
        int age=10/0;
        return "********testD";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2)
    {
//        int mi=10/0;
        return "****************testHotkey";
    }
    public String deal_testHotkey(String p1, String p2, BlockException e){
        return "****************deal_testHotkey";
    }
}

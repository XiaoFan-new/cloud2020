package com.fan.springcloud.controller;

import com.fan.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by fan
 * on 2020/5/16 14:38
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }
}

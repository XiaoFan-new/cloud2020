package com.fan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by fan
 * on 2020/5/13 15:07
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//定义为随机
    }
}

package com.fan.springcloud.service.impl;

import com.fan.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * Create by fan
 * on 2020/5/14 16:31
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymnetInfo_OK(Integer id) {
        return "-------------paymnetInfo_OK,  DOWN机了~！";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------------paymentInfo_TimeOut,DOWN机了~！";
    }
}

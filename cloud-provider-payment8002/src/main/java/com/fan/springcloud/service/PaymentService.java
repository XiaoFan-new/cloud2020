package com.fan.springcloud.service;

import com.fan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //新增
    public int create(Payment payment);
    //根据id查询
    public Payment getPaymentById(@Param("id") Long id);

}

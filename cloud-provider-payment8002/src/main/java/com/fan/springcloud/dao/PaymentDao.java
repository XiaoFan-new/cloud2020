package com.fan.springcloud.dao;

import com.fan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    //新增
    public int create(Payment payment);
    //根据id查询
    public Payment getPaymentById(@Param("id") Long id);

}

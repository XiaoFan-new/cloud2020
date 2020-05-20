package com.fan.springcloud.service.impl;

import com.fan.springcloud.dao.PaymentDao;
import com.fan.springcloud.entities.Payment;
import com.fan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

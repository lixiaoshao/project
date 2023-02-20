package com.honor.fly.service.impl;

import com.honor.fly.dao.PaymentDao;
import com.honor.fly.entity.Payment;
import com.honor.fly.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.honor.fly.service.impl
 *
 * @author honor-ljp
 * 2023/1/11 15:24
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

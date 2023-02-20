package com.honor.fly.service;

import com.honor.fly.entity.Payment;

/**
 * com.honor.fly.service
 *
 * @author honor-ljp
 * 2023/1/11 15:23
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}

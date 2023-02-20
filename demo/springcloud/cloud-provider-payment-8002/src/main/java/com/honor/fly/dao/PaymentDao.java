package com.honor.fly.dao;

import com.honor.fly.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * com.honor.fly.dao
 *
 * @author honor-ljp
 * 2023/1/11 15:14
 */
@Mapper
@Repository
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

package com.honor.fly.dao;

import com.honor.fly.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * com.honor.fly.dao
 *
 * @author honor-ljp
 * 2023/1/25 11:01
 */
@Mapper
@Repository
public interface OrderDao {
    void create(Order order);
    void update(@Param("orderId") Long orderId, @Param("status") Integer status);
}

package com.honor.fly.service.impl;

import com.honor.fly.dao.OrderDao;
import com.honor.fly.domain.Order;
import com.honor.fly.service.AccountService;
import com.honor.fly.service.OrderService;
import com.honor.fly.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * com.honor.fly.service.impl
 *
 * @author honor-ljp
 * 2023/1/25 11:32
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Resource
    AccountService accountService;
    @Resource
    StorageService storageService;

    @GlobalTransactional(name = "create-order", rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("------- 开始新建订单");
        orderDao.create(order);
        log.info("订单微服务开始调用库存做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("扣减余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("更改状态" + order.getId());
        orderDao.update(order.getId(), 0);
    }
}

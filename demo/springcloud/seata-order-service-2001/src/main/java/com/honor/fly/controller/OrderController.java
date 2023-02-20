package com.honor.fly.controller;

import com.honor.fly.domain.Order;
import com.honor.fly.entity.CommonResult;
import com.honor.fly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/25 14:16
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功！");
    }
}

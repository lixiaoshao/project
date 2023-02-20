package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import com.honor.fly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/25 14:52
 */
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money) throws InterruptedException {
        if (userId == 1) {
            throw new NullPointerException();
        }
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减余额成功");
    }
}

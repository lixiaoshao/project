package com.honor.fly.service;

import com.honor.fly.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * com.honor.fly.service
 *
 * @author honor-ljp
 * 2023/1/25 11:31
 */
@FeignClient("seata-account-service")
public interface AccountService {
    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId,
                          @RequestParam("money") BigDecimal money);
}

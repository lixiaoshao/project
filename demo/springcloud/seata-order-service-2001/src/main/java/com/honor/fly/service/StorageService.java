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
@FeignClient("seata-storage-service")
public interface StorageService {
    @RequestMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("total") Integer total);
}

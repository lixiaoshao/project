package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import com.honor.fly.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/25 14:30
 */
@RestController
@RequestMapping("/storage")
public class StorageController {
    @Autowired
    StorageService storageService;

    @RequestMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                          @RequestParam("total") Integer total) {
        storageService.decrease(productId, total);
        return new CommonResult(200, "扣减库存成功！");
    }
}

package com.honor.fly.controller;

import com.honor.fly.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.honor.fly.controller
 *
 * @author honor-ljp
 * 2023/1/11 15:32
 */
@RestController
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected CommonResult success(Object data) {
        return new CommonResult<>(data);
    }
    protected CommonResult success() {
        return new CommonResult<>();
    }

    protected CommonResult fail(Integer code, String message) {
        return new CommonResult(code, message);
    }
}

package com.honor.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * com.honor.springboot.exception
 *
 * @author honor-ljp
 * 2023/1/4 14:46
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({NullPointerException.class})
    public String dealError(Exception e) {
        log.error("NullPointerException异常", e);
        return "error";
    }
}

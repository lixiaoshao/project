package com.honor.springboot.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.honor.springboot.exception
 *
 * @author honor-ljp
 * 2023/1/4 15:39
 */
//@Component
@Order(Ordered.HIGHEST_PRECEDENCE)   // 异常解析器优先级
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            request.setAttribute("message", "自定义异常解析器");
            response.sendError(HttpStatus.NOT_IMPLEMENTED.value(), "自定义异常解析器");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}

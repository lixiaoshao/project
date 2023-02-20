package com.honor.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * com.honor.springboot.interceptor
 *
 * @author honor-ljp
 * 2023/1/4 11:00
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle:{}-{}", request.getRequestURI(), Thread.currentThread().getName());
        Object user = request.getSession().getAttribute("user");
        if (Objects.isNull(user)) {
            request.setAttribute("msg", "需要登录！");
            request.getRequestDispatcher("/thymeleaf/login.html").forward(request, response);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle:{}", Thread.currentThread().getName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion:{}", Thread.currentThread().getName());
    }
}

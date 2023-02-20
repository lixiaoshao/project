package com.honor.fly;

import org.springframework.stereotype.Service;

/**
 * com.honor.fly
 *
 * @author honor-ljp
 * 2023/1/15 22:12
 */
@Service
public class  PaymentServiceFallback implements PaymentService {
    @Override
    public String ok(Integer id) {
        return "ok fallback";
    }

    @Override
    public String timeOut(Integer id) {
        return "timeout fallback";
    }
}

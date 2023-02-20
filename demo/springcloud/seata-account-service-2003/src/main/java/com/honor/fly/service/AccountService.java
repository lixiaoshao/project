package com.honor.fly.service;

import java.math.BigDecimal;

/**
 * com.honor.fly.service
 *
 * @author honor-ljp
 * 2023/1/25 14:51
 */
public interface AccountService {
    void decrease(Long userId, BigDecimal money);
}

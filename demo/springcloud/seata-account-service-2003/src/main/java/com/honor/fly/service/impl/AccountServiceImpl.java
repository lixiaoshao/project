package com.honor.fly.service.impl;

import com.honor.fly.dao.AccountDao;
import com.honor.fly.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * com.honor.fly.service.impl
 *
 * @author honor-ljp
 * 2023/1/25 14:51
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }
}

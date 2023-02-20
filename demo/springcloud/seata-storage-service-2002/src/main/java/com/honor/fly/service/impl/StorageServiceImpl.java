package com.honor.fly.service.impl;

import com.honor.fly.dao.StorageDao;
import com.honor.fly.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.honor.fly.service.impl
 *
 * @author honor-ljp
 * 2023/1/25 14:37
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer total) {
        storageDao.decrease(productId, total);
    }
}

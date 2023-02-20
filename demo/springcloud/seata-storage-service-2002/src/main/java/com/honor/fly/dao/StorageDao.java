package com.honor.fly.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * com.honor.fly.dao
 *
 * @author honor-ljp
 * 2023/1/25 14:32
 */
@Mapper
@Repository
public interface StorageDao {
    void decrease(@Param("productId") Long productId, @Param("total") Integer total);
}

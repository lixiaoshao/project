package com.honor.fly.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * com.honor.fly.dao
 *
 * @author honor-ljp
 * 2023/1/25 14:46
 */
@Mapper
@Repository
public interface AccountDao {
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}

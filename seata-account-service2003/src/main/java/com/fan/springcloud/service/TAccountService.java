package com.fan.springcloud.service;

import com.fan.springcloud.entity.TAccount;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户表(TAccount)表服务接口
 *
 * @author makejava
 * @since 2020-05-20 16:38:56
 */
public interface TAccountService {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
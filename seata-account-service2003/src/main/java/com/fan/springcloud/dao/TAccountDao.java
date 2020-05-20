package com.fan.springcloud.dao;

import com.fan.springcloud.entity.TAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * 账户表(TAccount)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-20 16:38:56
 */
@Mapper
public interface TAccountDao {

    void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);


}
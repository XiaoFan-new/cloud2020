package com.fan.springcloud.dao;

import com.fan.springcloud.entity.TStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 库存(TStorage)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-20 15:54:39
 */
@Mapper
public interface TStorageDao {
    //减少库存
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
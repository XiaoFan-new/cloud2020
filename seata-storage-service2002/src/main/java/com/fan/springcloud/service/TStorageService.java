package com.fan.springcloud.service;

import com.fan.springcloud.entity.TStorage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存(TStorage)表服务接口
 *
 * @author makejava
 * @since 2020-05-20 15:54:39
 */
public interface TStorageService {

    //减少库存
    void decrease(Long productId,  Integer count);

}
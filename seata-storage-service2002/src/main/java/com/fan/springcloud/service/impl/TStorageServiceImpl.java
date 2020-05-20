package com.fan.springcloud.service.impl;

import com.fan.springcloud.entity.TStorage;
import com.fan.springcloud.dao.TStorageDao;
import com.fan.springcloud.service.TStorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 库存(TStorage)表服务实现类
 *
 * @author makejava
 * @since 2020-05-20 15:54:40
 */
@Service("tStorageService")
@Slf4j
public class TStorageServiceImpl implements TStorageService {
    @Resource
    private TStorageDao tStorageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("************>storage-service中减少库存开始");
        tStorageDao.decrease(productId,count);
        log.info("************>storage-service中减少库存结束");
    }
}
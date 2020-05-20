package com.fan.springcloud.service.impl;


import com.fan.springcloud.dao.TAccountDao;
import com.fan.springcloud.service.TAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;


/**
 * 账户表(TAccount)表服务实现类
 *
 * @author makejava
 * @since 2020-05-20 16:38:56
 */
@Service("tAccountService")
@Slf4j
public class TAccountServiceImpl implements TAccountService {
    @Resource
    private TAccountDao tAccountDao;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("-----------sccount-service中扣除账户余额开始");
        //m默认超时出错，全局失误回滚
        //try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        tAccountDao.decrease(userId,money);
        log.info("-----------sccount-service中扣除账户余额结束");
    }
}
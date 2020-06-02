package com.lhy.springcloud.service.impl;

import com.lhy.springcloud.dao.AccountDao;
import com.lhy.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:21
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----> account-service中扣减用户余额开始");
        Time.sleep(20000);
        accountDao.decrease(userId,money);
        log.info("----> account-service中扣减用户余额开始");
    }

}

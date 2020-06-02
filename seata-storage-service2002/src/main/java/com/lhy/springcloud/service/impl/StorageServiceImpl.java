package com.lhy.springcloud.service.impl;

import com.lhy.springcloud.dao.StorageDao;
import com.lhy.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:34
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("----> storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("----> storage-service中扣减库存结束");
    }

}

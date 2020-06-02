package com.lhy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述:
 * 创建人:    lihy  
 * 创建时间:  2020/06/02 0:10
 */
@Configuration
@MapperScan({"com.lhy.springcloud.dao"})
public class MybatisConfig {
}

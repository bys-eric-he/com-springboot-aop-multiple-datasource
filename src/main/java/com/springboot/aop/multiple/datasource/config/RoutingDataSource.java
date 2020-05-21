package com.springboot.aop.multiple.datasource.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 1. 注意:mybatis数据源为lazy加载
 * 2. 当第一次访问数据时底层会重复访问AbstractRoutingDataSource的determineTargetDataSource方法,调试阶段不要介意,因为只有服务重启才会重复一次
 * 3. 新增数据源需要新增数据源bean对象以及整合SqlSession
 * 4. 新增数据时这个类不用动
 */
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        // 从自定义的位置获取数据源标识
        return DataSourceHolder.getDataSource();
    }
}
package com.springboot.aop.multiple.datasource.config;

import lombok.extern.slf4j.Slf4j;

/**
 * 当前线程的数据源
 */
@Slf4j
public class DataSourceHolder {

    private static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<>();

    /**
     * 获取当前数据源
     *
     * @return
     */
    public static String getDataSource() {
        log.warn(String.format("当前数据源[%s]", THREAD_DATA_SOURCE.get()));
        return THREAD_DATA_SOURCE.get();
    }

    /**
     * 设置当前数据源
     *
     * @param dataSource
     */
    public static void setDataSource(String dataSource) {
        log.warn(String.format("切换至[%s]数据源", dataSource));
        THREAD_DATA_SOURCE.set(dataSource);
    }

    /**
     * 清空当前数据源
     */
    public static void clearDataSource() {
        log.warn("清空数据源!");
        THREAD_DATA_SOURCE.remove();
    }
}

package com.springboot.aop.multiple.datasource.config;

/**
 * @author eric.he
 *
 * 数据源,新增数据源需要新增属性
 */
public enum DataSourceKey {
    /**
     * 主库
     */
    MASTER("Master"),
    /**
     * 从库
     */
    SLAVE("Slave");

    private String key;

    DataSourceKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
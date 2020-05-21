package com.springboot.aop.multiple.datasource.annotation;

import com.springboot.aop.multiple.datasource.config.DataSourceKey;

import java.lang.annotation.*;

/**
 * 注意:该注解在mapper层和service层实现类的方法都可用,根据开发需求定制.
 * 1. 如果该service都是查询功能,建议在service上注解
 * 2. 如果有CRUD操作则选择在mapper层注解
 * 3. 默认数据库为master
 * 4. 新增数据源时这里不需要调整改动
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceKey value() default DataSourceKey.MASTER;
}

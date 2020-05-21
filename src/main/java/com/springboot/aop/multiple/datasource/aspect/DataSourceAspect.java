package com.springboot.aop.multiple.datasource.aspect;

import com.springboot.aop.multiple.datasource.annotation.TargetDataSource;
import com.springboot.aop.multiple.datasource.config.DataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
@Aspect
@Component
@Order(-999)
@Slf4j
public class DataSourceAspect implements Ordered {
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.springboot.aop.multiple.datasource.annotation.TargetDataSource)")
    public void dataSourcePointCut() {
    }

    /**
     * 该处选择环绕通知,目的为了清除当前线程的ThreadLocal数据,防止内存泄漏
     */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        TargetDataSource dataSource = method.getAnnotation(TargetDataSource.class);
        DataSourceHolder.setDataSource(dataSource.value().getKey());
        log.info("数据源已切换,当前数据库: {}", dataSource.value().getKey());
        try {
            return point.proceed();
        } finally {
            //防止ThreadLocal内存泄漏
            DataSourceHolder.clearDataSource();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
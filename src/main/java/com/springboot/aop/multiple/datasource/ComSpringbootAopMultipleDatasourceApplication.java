package com.springboot.aop.multiple.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * exclude = {DataSourceAutoConfiguration.class}
 * 禁用springboot默认加载的application.properties单数据源配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.springboot.aop.multiple.datasource.mapper")
public class ComSpringbootAopMultipleDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComSpringbootAopMultipleDatasourceApplication.class, args);
    }

}

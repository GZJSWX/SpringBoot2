package com.atwangxin.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan 表示com.atwangxin.springboot.mapper下的所有文件都相当于加了@Mapper注解
 */
@MapperScan(basePackages = {"com.atwangxin.springboot.mapper"})
@SpringBootApplication
public class SpringBoot05DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot05DataMybatisApplication.class, args);
    }

}

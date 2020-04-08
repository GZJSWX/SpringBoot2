package com.atwangxin.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class SpringBoot06DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06DataJpaApplication.class, args);
    }

}

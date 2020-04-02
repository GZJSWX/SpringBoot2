package com.springboot.web;

import com.springboot.web.dao.EmployeeDao;
import com.springboot.web.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class SpringbootwebApplicationTests {
    @Autowired
    EmployeeDao employeeDao;

    @Test
    void contextLoads() {
    }

    @Test
    void getEmps(){

        Collection<Employee> employess = employeeDao.getAll();
        System.out.println(employess);
    }

}

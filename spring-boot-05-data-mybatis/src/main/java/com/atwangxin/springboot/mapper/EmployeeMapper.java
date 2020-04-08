package com.atwangxin.springboot.mapper;

import com.atwangxin.springboot.bean.Employee;

//@Mapper或@MapperScan将接口扫描装配到容器
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}

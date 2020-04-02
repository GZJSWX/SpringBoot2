package com.springboot.web.entities;

import java.util.Date;

/**
 * 定义部门成员 模型
 * id
 * lastName
 * email
 * gender:1 meal（男），0 female（女）
 * birth Date （时间日期类）
 * department:Department 部门 （定义部门类对象）
 *
 */
public class Employee {
    //定义部门成员
    private Integer id;
    private String  lastName;
    private String  email;
    private Integer gender;
    private Date birth;
    private Department department;

    //空构造方法
    public Employee(){}
    //初始化构造方法 （alt+Insert ->Constructer）

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birth = new Date();
        this.department = department;
    }

    //get and set

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    //toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", department=" + department +
                '}';
    }
}

package com.atwangxin.springboot.entity;

import javax.persistence.*;

//使用JPA注解配置映射关系
//告诉JPA这是一个实体类（和数据表映射的类）
@Entity(name = "tbl_user")
//@Table 来指定和哪个数据表对应，不写则默认表名就是类名 user
public class User {

    @Id   //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增主键
    private Integer id;

    @Column(name = "last_name",length=50)   //这是一个和数据表对应的一个列
    private String lastName;
    @Column   //省略默认类名就是属性名
    private String email;

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
}

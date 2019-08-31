package com.ldp.gitdemo.pojo;

import javax.persistence.*;

/**
 * 用户实体类
 */
@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id生成策略
    @Column(name = "id")
    private Integer id;//id  主键
    @Column(name = "username")
    private String username;//用户名
    @Column(name = "password")
    private String password;//密码
}

package com.ldp.gitdemo.pojo;

import javax.persistence.*;

/**
 * 角色实体类
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id生成策略
    @Column(name = "id")
    private Integer id;//主键
    @Column(name = "role_name")
    private String roleName;//角色名称
    @Column(name = "role_code")
    private String roleCode;//角色标识
}

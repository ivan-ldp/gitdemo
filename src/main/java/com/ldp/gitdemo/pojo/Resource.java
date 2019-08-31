package com.ldp.gitdemo.pojo;

import javax.persistence.*;

/**
 * 资源表
 */
@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id生成策略
    @Column(name = "id")
    private Integer id;//主键
    @Column(name = "res_name")
    private String resName;//资源名称
    @Column(name = "res_code")
    private String resCode;//资源标识
    @Column(name = "url")
    private String url;//资源请求路径
}

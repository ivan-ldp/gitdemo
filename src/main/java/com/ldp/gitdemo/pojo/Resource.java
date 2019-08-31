package com.ldp.gitdemo.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    //private List<Role> roles=new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

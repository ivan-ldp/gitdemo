package com.ldp.gitdemo.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "role_resouce",joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "res_id",referencedColumnName = "id")})
    private List<Resource> resources=new ArrayList<>();//每个角色所能操作的所有资源

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
}

package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色Dao接口
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
}

package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 角色Dao接口
 */
public interface RoleRepository extends JpaSpecificationExecutor<Role>, JpaRepository<Role,Integer> {
}

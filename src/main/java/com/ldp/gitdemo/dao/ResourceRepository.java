package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 资源dao接口
 */
public interface ResourceRepository extends JpaSpecificationExecutor<Resource>, JpaRepository<Resource,Integer> {
}

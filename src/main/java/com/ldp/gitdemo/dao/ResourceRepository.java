package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 资源dao接口
 */
public interface ResourceRepository extends JpaRepository<Resource,Integer> {
}

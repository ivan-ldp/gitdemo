package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户dao接口
 * Repository 接口：作用： 命名方法查询 findBy+Username+条件（like） @Query注解方式查询
 * CrudRepository 接口 增删改查
 * PagingAndSortingRepository接口 排序分页
 * JpaRepository继承以上所有接口，包括自身提供的接口
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}

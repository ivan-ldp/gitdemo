package com.ldp.gitdemo.dao;

import com.ldp.gitdemo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * 用户dao接口
 * Repository 接口：作用： 命名方法查询 findBy+Username+条件（like） @Query注解方式查询
 * CrudRepository 接口 增删改查
 * PagingAndSortingRepository接口 排序分页
 * JpaRepository继承以上所有接口，包括自身提供的接口
 * jpaSpecificationExecutor 单独接口，复杂查询
 */
public interface UserRepository extends JpaSpecificationExecutor<User>,JpaRepository<User,Integer> {
    /**
     * 命名方式查询：按姓名查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 注解方式查询
     * @param username
     * @return
     */
    @Query("from User where username=?")
    User findUser(String username);
    /**
     * 注解方式查询 原生查询
     * @param username
     * @return
     */
    @Query(value = "from user where username=?",nativeQuery = true)
    User findUserSql(String username);
}

package com.ldp.gitdemo.config;

import com.ldp.gitdemo.realm.AuthRealm;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {
    //设置会话安全管理器
    @Bean
    public SessionsSecurityManager securityManager(AuthRealm authRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        return securityManager;
    }

    //设置过滤器shiroFilter
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SessionsSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        //设置会话管理器
        factoryBean.setSecurityManager(securityManager);
        //设置未登录时路径
        factoryBean.setLoginUrl("/unLogin");
        //设置拦截器
        Map<String,String> fileMaps=new HashMap<>();
        fileMaps.put("/login","anon");
        fileMaps.put("/logout","logout");
        fileMaps.put("/**","authc");
        factoryBean.setFilterChainDefinitionMap(fileMaps);
        return factoryBean;
    }
    //配置SecurityManager生命周期
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }
    //开启shiro注解
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }
}

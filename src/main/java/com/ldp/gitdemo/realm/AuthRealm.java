package com.ldp.gitdemo.realm;

import com.ldp.gitdemo.pojo.Resource;
import com.ldp.gitdemo.pojo.Role;
import com.ldp.gitdemo.pojo.User;
import com.ldp.gitdemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 自定义realm 进行认证与授权
 */
@Component
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //取出用户
        User user = (User)principalCollection.getPrimaryPrincipal();
        //通常会创建SimpleAuthorizationInfo对象  放权限与角色信息
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        for (Role role:user.getRoles()){
            //将角色标识加入到SimpleAuthorizationInfo对象当中
            info.addRole(role.getRoleCode());
            for (Resource resource:role.getResources()){
                //将资源标识与资源路径加入到SimpleAuthorizationInfo对象当中
               info.addStringPermission(resource.getResCode());
               info.addStringPermission(resource.getUrl());
            }
        }
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username=(String)authenticationToken.getPrincipal();
        //根据用户名查询用户信息
        User user = userService.findByUsername(username);
        if (null==user){
            throw new UnknownAccountException("用户名或密码错误");
        }
        //通常会创建SimpleAuthenticationInfo对象进行数据封装并返回
        //认证信息
        //密码
        //当前realm对象的name
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return info;
    }
}

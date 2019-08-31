package com.ldp.gitdemo.realm;

import com.ldp.gitdemo.pojo.User;
import com.ldp.gitdemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm 进行认证与授权
 */
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
        return null;
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
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return info;
    }
}

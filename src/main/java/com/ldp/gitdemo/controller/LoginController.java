package com.ldp.gitdemo.controller;

import com.ldp.gitdemo.pojo.User;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登陆
 */
@RestController
public class LoginController {
    private Map<String,Object> maps=new HashMap<>();

    /**
     * 登陆
     * @return
     */
    @GetMapping("/login")
    public Map<String,Object> login(String username,String password){
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        if (!subject.isAuthenticated()){
            try {
                subject.login(token);
                maps.put("status","200");
                maps.put("massage","登陆成功");
            }catch (UnknownAccountException e){
                maps.put("status","403");
                maps.put("massage",e.getMessage());
            }
        }
        return maps;
    }

    /**
     * 退出
     * @return
     */
    @GetMapping("/logout")
    public Map<String,Object> logout(){
        SecurityUtils.getSubject().logout();
        maps.put("status","200");
        maps.put("massage","退出登陆");
        return maps;
    }

    /**
     * 未登录
     * @return
     */
    @GetMapping("/unLogin")
    public Map<String,Object> unLogin(){
        maps.put("status","401");
        maps.put("massage","没有登陆");
        return maps;
    }
    /**
     * 没有权限
     * @return
     */
    @GetMapping("/unAuth")
    public Map<String,Object> ybAth(){
        maps.put("status","401");
        maps.put("massage","没有权限");
        return maps;
    }
}

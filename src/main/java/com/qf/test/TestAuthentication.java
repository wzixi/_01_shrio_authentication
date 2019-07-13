package com.qf.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class TestAuthentication {

    @Test
    public void test1(){
        //1.加载ini文件，通过工厂来创建SecurityManager对象
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        //2将安全管理器（SecurityManager）对象配置到应用程序中
        SecurityUtils.setSecurityManager(securityManager);
        //3获取当前主体用户
        Subject subject = SecurityUtils.getSubject();
        //4根据subject对象进行认证操作
        //根据用户输入的用户名密码组成UsernamePasswordToken对象
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("admin","1234");
        try{
            subject.login(usernamePasswordToken);


            //5验证登陆（认证）是否成功
            if(subject.isAuthenticated()) {
                System.out.println("login success");
                System.out.println(subject.isPermitted("user:update"));

            }
            //checkPermission和isPermitted区别
            //当检测账户没有某个权限时isPermitted返回false checkPermission抛出异常
            //判断账户具有的角色
            System.out.println(subject.hasRole("role2"));
            //获取当前账户的身份信息
            System.out.println(subject.getPrincipal());
        }catch (AuthenticationException e){
            System.out.println("login fail");
        }



    }
}

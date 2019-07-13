package com.qf.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        //假设获取到用户名，然后从数据库中查询到角色及权限列表
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        roles.add("role1");
        roles.add("role2");
        //根据角色列表查询数据库中的对应的权限列表
        Set<String> permission = new HashSet<String>();
        permission.add("user:add");
        permission.add("user:update");
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;





    }


    /*
    * 认证
    * @param authenticationToken
    * @return
    * @throws AuthenticationException
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        //假设根据用户名查询数据库啊查询到的密码为123
        String credential="1234";
        SimpleAuthenticationInfo simpleAuthenticationInfo= new SimpleAuthenticationInfo(username,credential,"MyRealm");
        return simpleAuthenticationInfo;
    }
}

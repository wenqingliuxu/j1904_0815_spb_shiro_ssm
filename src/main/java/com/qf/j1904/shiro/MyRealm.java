package com.qf.j1904.shiro;

import com.qf.j1904.pojo.SysPermission;
import com.qf.j1904.pojo.SysUser;
import com.qf.j1904.service.SysUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义的realm策略
 * Created by jeffrey on 2019/8/15.
 */
public class MyRealm extends AuthorizingRealm {
//    注入业务实现
    @Autowired
    private SysUserService userService;
//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        从身份信息集合中获取当前主体的身份信息
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();
        if(!StringUtils.isEmpty(primaryPrincipal)){
            String loginName = (String) primaryPrincipal;
            List<SysPermission> sysPermissions = userService.findPermissionsByLoginName(loginName);
//            权限去重
            Set<String> perms = new HashSet<>();
            for (SysPermission perm: sysPermissions) {
                String menu_url = perm.getPer_name();
                perms.add(menu_url);
            }
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//            授权
            authorizationInfo.setStringPermissions(perms);
            return authorizationInfo;
        }
        return null;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//          获取身份信息
        Object principal = token.getPrincipal();
        if(!StringUtils.isEmpty(principal)) {
            String loginName = (String) principal;
//            调用业务逻辑方法查询用户信息
            SysUser sysUser = userService.findUserByLoginName(loginName);
            ByteSource salt = ByteSource.Util.bytes("abc");
//            带加盐的认证
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(),salt, getName());
//            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(loginName, sysUser.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
    }
}

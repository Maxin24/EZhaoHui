package com.join.ezhaohui.realm;

import com.join.ezhaohui.entity.Permission;
import com.join.ezhaohui.entity.Role;
import com.join.ezhaohui.entity.User;
import com.join.ezhaohui.service.user.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {
    @Lazy
    @Resource
    UserService userServiceImpl;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username=(String) authenticationToken.getPrincipal();
        User user=userServiceImpl.selectUserByUsername(username);
        if(user==null)
            return null;

        SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()),getName());
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        String username =(String)principalCollection.getPrimaryPrincipal();
        User user=userServiceImpl.selectUserByUsername(username);

        for(Role role:user.getRoles()){
            authorizationInfo.addRole(role.getName());
            for(Permission permission:role.getPermissions()){
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }


}

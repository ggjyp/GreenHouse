package com.jyp.greenhouse.shiro;

import com.jyp.greenhouse.pojo.User;
import com.jyp.greenhouse.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Author   : jyp
 * Date     : 2017/3/13 10:52
 * Describe :
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString() ;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo() ;
        Set<String> roleName = userService.getRoles(username);
        Set<String> permissions = userService.getPermissions(username) ;
        info.setRoles(roleName);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户账号
        String username = token.getPrincipal().toString();
        User user = userService.getUserByName(username);
        if (user != null) {
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
                    getName());
            return authenticationInfo;
        } else {
            return null;

        }
    }

    @Override
    public String getName() {
        return getClass().getName();
    }
}

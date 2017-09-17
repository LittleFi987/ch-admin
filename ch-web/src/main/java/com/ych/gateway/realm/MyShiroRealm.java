package com.ych.gateway.realm;

import com.ych.admin.dto.UserDTO;
import com.ych.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * Created by chenhaoye on 2017/9/16.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    @Resource
    private UserService userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户名
        String userName = (String)authenticationToken.getPrincipal();
        UserDTO userDTOByName = userService.findUserByName(userName);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userDTOByName.getUserName(), //用户名
                userDTOByName.getPwd(), //密码
                ByteSource.Util.bytes(userDTOByName.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(userName);
        return null;
    }
}

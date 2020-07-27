package com.jake.csamanagement.util;

import com.jake.csamanagement.dao.UserMapper;
import com.jake.csamanagement.util.JWTToken;
import com.jake.csamanagement.util.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    private UserMapper userMapper;

    @Autowired
    private void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //        权限认证方法
//        System.out.println("正在执行权限认证...");
        String username = JWTUtil.getUsername(principals.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userMapper.getRoleByUsername(username)+"";
        Set<String> roleSet = new HashSet<>();
        roleSet.add(role);
        info.setRoles(roleSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        身份认证方法
//        System.out.println("正在执行身份认证...");
        String UPtoken= (String)token.getCredentials();
        String username = JWTUtil.getUsername(UPtoken);

        int verfyStatus=JWTUtil.verify(UPtoken, username);

        if (verfyStatus==2) {
//            System.out.println("token过期！");
            throw new AuthenticationException("token过期！");
        }

        if (verfyStatus==3) {
//            System.out.println("token验证错误！");
            throw new AuthenticationException("token验证错误！");
        }

        String password=userMapper.getPasswordByUsername(username);
        if(null==password)
        {
//            System.out.println("该用户不存在");
            throw new AccountException("该用户不存在");
        }
//        else if(!password.equals(new String((char[]) UPtoken.getCredentials()))){
//            throw new AccountException("密码不正确");
//        }
//        System.out.println("身份认证成功");
        return new SimpleAuthenticationInfo(UPtoken, UPtoken, "MyRealm");
    }
}

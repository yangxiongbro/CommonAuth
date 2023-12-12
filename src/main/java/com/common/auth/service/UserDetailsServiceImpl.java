package com.common.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <b><code>UserDetailsServiceImpl</code></b>
 * <p/>
 * UserDetailsService实现类
 * <p/>
 * <b>Creation Time:</b> 2023/12/12 22:13
 *
 * @author yang xiong
 * @since CommonAuth 1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1.根据用户名去数据库查询，如果不存在抛UsernameNotFoundException异常
        if (!"admin".equals(username)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        //2.比较密码(注册时已经加密过)，如果匹配成功返回UserDetails
        // 123
        String rawPassword = "1234";
        String passwordFromStorage = passwordEncoder.encode(rawPassword);
        System.out.println("自定义登录");
        System.out.println(passwordFromStorage);
        return new User(username, passwordFromStorage, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}

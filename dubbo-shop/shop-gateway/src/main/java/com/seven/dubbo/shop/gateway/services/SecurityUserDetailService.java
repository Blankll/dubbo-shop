package com.seven.dubbo.shop.gateway.services;

import com.seven.dubbo.shop.api.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.services
 * @date: 8/23/20
 * @version: 1.0
 */
@Service
public class SecurityUserDetailService implements UserDetailsService {
    @DubboReference
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.seven.dubbo.shop.entities.User user = userService.findByEmail(username);
        if (null == user) {
            throw new UsernameNotFoundException("user not exists");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}

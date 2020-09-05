package com.seven.dubbo.shop.gateway.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.services
 * @date: 8/23/20
 * @version: 1.0
 */
@Service
public class SecurityUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("blank", "0707", new ArrayList<>());
    }
}

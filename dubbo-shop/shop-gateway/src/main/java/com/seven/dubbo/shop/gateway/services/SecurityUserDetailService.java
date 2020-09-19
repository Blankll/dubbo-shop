package com.seven.dubbo.shop.gateway.services;

import com.seven.dubbo.shop.api.UserService;
import com.seven.dubbo.shop.exceptions.ExternalException;
import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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
        Optional<com.seven.dubbo.shop.entities.User> optionalUser = userService.findByEmail(username);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("user not exists");
        }
        com.seven.dubbo.shop.entities.User user = optionalUser.get();
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}

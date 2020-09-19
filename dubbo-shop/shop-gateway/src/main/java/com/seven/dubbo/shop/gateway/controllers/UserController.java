package com.seven.dubbo.shop.gateway.controllers;

import com.seven.dubbo.shop.api.UserService;
import com.seven.dubbo.shop.entities.User;
import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;
import com.seven.dubbo.shop.exceptions.ExternalException;
import com.seven.dubbo.shop.gateway.requests.RegisterRequest;
import com.seven.dubbo.shop.gateway.requests.UserLoginRequest;
import com.seven.dubbo.shop.gateway.services.SecurityUserDetailService;
import com.seven.dubbo.shop.gateway.utils.JWTUtil;
import com.seven.dubbo.shop.gateway.utils.Resp;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.controllers
 * @date: 7/3/20
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityUserDetailService userDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @DubboReference
    private UserService userService;

    @PostMapping("/register")
    public Resp<User> register(@Valid RegisterRequest request) throws ExternalException {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user);
        return new Resp<>(user);
    }

    @PostMapping("/login")
    public Resp<String> login(@Valid UserLoginRequest loginRequest) throws ExternalException {
        try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword())
        );
        } catch (BadCredentialsException e) {
            throw new ExternalException(ExceptionEnum.USER_NOT_EXISTS);
        }
        UserDetails userDetails = userDetailService.loadUserByUsername(loginRequest.getUsername());
        String token = jwtUtil.getToken(loginRequest.getUsername());

        return new Resp<String>(token);
    }
}

package com.seven.dubbo.shop.gateway.requests;

import javax.validation.constraints.NotBlank;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.requests
 * @date: 7/3/20
 * @version: 1.0
 */
public class UserLoginRequest {
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

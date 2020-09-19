package com.seven.dubbo.shop.gateway.requests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.requests
 * @date: 9/19/20
 * @version: 1.0
 */
public class RegisterRequest {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

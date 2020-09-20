package com.seven.dubbo.shop.api;

import com.seven.dubbo.shop.entities.User;
import com.seven.dubbo.shop.exceptions.ExternalException;

import java.util.Optional;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.api
 * @date: 9/19/20
 * @version: 1.0
 */
public interface UserService {
    Long create(User user) throws ExternalException;
    User findByEmail(String email);
}

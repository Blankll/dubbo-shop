package com.seven.dubbo.shop.user.services;

import com.seven.dubbo.shop.api.UserService;
import com.seven.dubbo.shop.entities.User;
import com.seven.dubbo.shop.exceptions.ExternalException;
import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;
import com.seven.dubbo.shop.user.mappers.UserMapper;
import com.seven.dubbo.shop.utils.IdService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.user.services
 * @date: 9/19/20
 * @version: 1.0
 */
@Component
@DubboService
public class UserServiceImpl implements UserService {
    @Autowired
    private IdService idService;
    @Resource
    private UserMapper userMapper;
    @Override
    public Long create(User user) throws ExternalException {
        user.setId(idService.generateId());
        try {
            userMapper.create(user);
        } catch (DuplicateKeyException e) {
            throw new ExternalException(ExceptionEnum.USER_ALREADY_EXISTS);
        }

        return user.getId();
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }
}

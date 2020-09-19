package com.seven.dubbo.shop.user.mappers;

import com.seven.dubbo.shop.entities.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.user.mappers
 * @date: 9/19/20
 * @version: 1.0
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `users`(`id`, `email`, `username`, `password`, `phone`) VALUES(#{id}, #{email}, #{username}, #{password}, #{phone});")
    void create(User user);
    @Select("SELECT * FROM `users` WHERE email=#{email};")
    Optional<User> findByEmail(String email);
}

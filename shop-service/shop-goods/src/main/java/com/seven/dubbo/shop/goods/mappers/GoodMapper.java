package com.seven.dubbo.shop.goods.mappers;

import com.seven.dubbo.shop.entities.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.goods.mappers
 * @date: 9/13/20
 * @version: 1.0
 */
@Mapper
public interface GoodMapper {

    @Select("SELECT `id`, `name`, `name`, `quantity`, `price`, `desc`, `created`, `updated` FROM goods")
    List<Good> getAvailable();
}

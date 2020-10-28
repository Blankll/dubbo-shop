package com.seven.dubbo.shop.goods.services;

import com.seven.dubbo.shop.api.GoodService;
import com.seven.dubbo.shop.entities.Good;
import com.seven.dubbo.shop.goods.mappers.GoodMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.goods.services
 * @date: 7/2/20
 * @version: 1.0
 */
@Component
@DubboService
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;
    @Override
    public List<Good> getAllAvailableGoods() {
        return goodMapper.getAvailable();
    }
}

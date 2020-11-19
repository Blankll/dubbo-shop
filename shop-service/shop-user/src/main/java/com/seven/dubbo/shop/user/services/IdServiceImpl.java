package com.seven.dubbo.shop.user.services;

import com.seven.dubbo.shop.utils.IdService;
import com.seven.dubbo.shop.utils.SnowFlake;
import org.springframework.stereotype.Service;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.user.services
 * @date: 9/19/20
 * @version: 1.0
 */
@Service
public class IdServiceImpl implements IdService {
    private final SnowFlake snowFlake;
    public IdServiceImpl() {
        this.snowFlake = new SnowFlake(1L, 10L);
    }
    @Override
    public Long generateId() { return snowFlake.nextId(); }
}

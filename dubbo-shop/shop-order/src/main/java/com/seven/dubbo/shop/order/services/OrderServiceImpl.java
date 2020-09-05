package com.seven.dubbo.shop.order.services;

import com.seven.dubbo.shop.api.OrderService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.order.services
 * @date: 7/3/20
 * @version: 1.0
 */
@Component
@DubboService
public class OrderServiceImpl implements OrderService {
    @Override
    public String confirmOrder() {
        return null;
    }
}

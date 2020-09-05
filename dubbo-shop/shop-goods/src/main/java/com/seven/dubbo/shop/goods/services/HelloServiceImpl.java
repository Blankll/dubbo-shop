package com.seven.dubbo.shop.goods.services;

import com.alibaba.dubbo.config.annotation.Service;
import com.seven.dubbo.shop.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.goods.services
 * @date: 7/2/20
 * @version: 1.0
 */
@Component
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "goods service impl:" + name;
    }
}

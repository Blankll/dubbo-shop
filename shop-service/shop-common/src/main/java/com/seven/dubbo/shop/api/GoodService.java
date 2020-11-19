package com.seven.dubbo.shop.api;

import com.seven.dubbo.shop.entities.Good;

import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.api
 * @date: 9/6/20
 * @version: 1.0
 */
public interface GoodService {
    List<Good> getAllAvailableGoods();
}

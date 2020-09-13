package com.seven.dubbo.shop.gateway.controllers;

import com.seven.dubbo.shop.api.GoodService;
import com.seven.dubbo.shop.entities.Good;
import com.seven.dubbo.shop.gateway.utils.Resp;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.controllers
 * @date: 9/6/20
 * @version: 1.0
 */
@RestController
@RequestMapping("/goods")
public class GoodController {
    @DubboReference
    private GoodService goodService;

    @GetMapping
    public Resp<List<Good>> getAllAvailableGoods() {
        List<Good> goods = goodService.getAllAvailableGoods();

        return new Resp<>(goods);
    }
}

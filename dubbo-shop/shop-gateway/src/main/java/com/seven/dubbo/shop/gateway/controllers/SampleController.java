package com.seven.dubbo.shop.gateway.controllers;

import com.seven.dubbo.shop.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.controllers
 * @date: 7/2/20
 * @version: 1.0
 */
@RestController
@RequestMapping("/sample")
public class SampleController {
    @DubboReference
    private HelloService helloService;

    @GetMapping
    public String hello(@RequestParam(name = "name", defaultValue = "name not get") String name) {
        return helloService.sayHello(name);
    }
}

package com.seven.dubbo.shop.gateway.builders;

import com.seven.dubbo.shop.entities.Good;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.builders
 * @date: 9/6/20
 * @version: 1.0
 */
public class GoodBuilder {
    private Long id = null;
    private String name = "IPhone 4";
    private Integer quantity = 900;
    private BigDecimal price = BigDecimal.valueOf(5299);
    private String desc = "IPhone 4S, new generation smart phone, with IOS 6 system.";
    private Timestamp created = new Timestamp(1599399927);
    private Timestamp updated = new Timestamp(1599399927);

    public GoodBuilder withId(Long id) {
        this.id = id;
        return this;
    }
    public GoodBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public GoodBuilder withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
    public GoodBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;

    }
    public GoodBuilder withDesc(String desc) {
        this.desc = desc;
        return this;
    }
    public GoodBuilder withCreated(Long timestamp) {
        this.created = new Timestamp(timestamp);
        return this;
    }
    public GoodBuilder withUpdated(Long timestamp) {
        this.updated = new Timestamp(timestamp);
        return this;
    }

    public Good build() {
        Good good = new Good();
        good.setId(this.id);
        good.setName(this.name);
        good.setQuantity(this.quantity);
        good.setPrice(this.price);
        good.setDesc(this.desc);
        good.setCreated(this.created);
        good.setUpdated(this.updated);
        return good;
    }

}

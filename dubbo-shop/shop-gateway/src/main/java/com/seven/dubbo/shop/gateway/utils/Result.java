package com.seven.dubbo.shop.gateway.utils;

/**
 * @ author: Blank
 * @ description: http返回封包, status为http code, result为请求返回数据
 * @ date: 1/19/20
 * @ version: 1.0
 */

public class Result <T> {
    private Integer status;
    private Resp<T> result;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Resp<T> getResult() {
        return result;
    }

    public void setResult(Resp<T> result) {
        this.result = result;
    }
}

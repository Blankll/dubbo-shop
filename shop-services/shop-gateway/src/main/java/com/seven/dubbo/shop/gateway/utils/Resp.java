package com.seven.dubbo.shop.gateway.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Blank
 * @description: 统一返回数据格式
 * @param code 请求结果自定义代码
 * @param messages 请求消息
 * @param data 请求返回的数据
 * @date: 1/19/20
 * @version: 1.0
 */
public class Resp<T> {
    private Integer code;
    private List<String> messages = new ArrayList<>();
    private T data;

    public void setCode(Integer code){
        this.code = code;
    }
    public Integer getCode(){
        return this.code;
    }
    public void setData(T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Resp(Integer code, String message, T data) {
        this.code = code;
        this.messages.add(message);
        this.data = data;
    }

    public Resp(T data) {
        this(2000, "操作成功", data);
    }
    public Resp(String message, T data) {
        this(2000, message, data);
    }
    public Resp() {
    }

    public void addMessage(String message) {
        this.messages.add(message);
    }
}

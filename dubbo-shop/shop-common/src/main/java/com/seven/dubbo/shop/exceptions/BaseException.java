package com.seven.dubbo.shop.exceptions;

import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;

/**
 * @author: Blank
 * @description: com.shu.backend.exceptions
 * @date: 1/19/20
 * @version: 1.0
 */
public class BaseException extends Exception {
    protected HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    protected Integer code = 5000;
    protected String message;

    public BaseException(ExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getStatus();
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMessage();
    }
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

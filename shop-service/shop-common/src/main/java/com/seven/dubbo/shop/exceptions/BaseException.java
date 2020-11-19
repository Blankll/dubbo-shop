package com.seven.dubbo.shop.exceptions;

import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;
import org.springframework.http.HttpStatus;

/**
 * @author: Blank
 * @description: com.shu.backend.exceptions
 * @date: 1/19/20
 * @version: 1.0
 */
public class BaseException extends RuntimeException {
    private ExceptionEnum exceptionEnum;
    public BaseException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}

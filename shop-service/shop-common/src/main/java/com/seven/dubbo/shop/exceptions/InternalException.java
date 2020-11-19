package com.seven.dubbo.shop.exceptions;

import com.seven.dubbo.shop.exceptions.enums.ExceptionEnum;

/**
 * @author: Blank
 * @description: com.shu.backend.exceptions
 * @date: 1/19/20
 * @version: 1.0
 */
public class InternalException extends BaseException {
    public InternalException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum);
    }
}

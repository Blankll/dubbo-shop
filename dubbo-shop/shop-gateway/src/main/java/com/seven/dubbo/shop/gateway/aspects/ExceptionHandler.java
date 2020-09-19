package com.seven.dubbo.shop.gateway.aspects;

import com.seven.dubbo.shop.exceptions.ExternalException;
import com.seven.dubbo.shop.exceptions.InternalException;
import com.seven.dubbo.shop.gateway.utils.Resp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: Blank
 * @description: com.seven.dubbo.shop.gateway.aspects
 * @date: 7/3/20
 * @version: 1.0
 */
@ControllerAdvice
public class ExceptionHandler {
    @Value("${debug}")
    private boolean isDebug;

    @org.springframework.web.bind.annotation.ExceptionHandler(Throwable.class)
    public ResponseEntity<Resp> defaultHandler(HttpServletRequest req, Exception e) {
        Resp<String> resp = new Resp<>();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        // 用户自定义请求失败
        if (e instanceof ExternalException) {
            ExternalException externalException = (ExternalException) e;
            resp.setCode(externalException.getCode());
            resp.addMessage(e.getMessage());
            status = externalException.getStatus();
        }
        // 用户自定义服务器内部错误
        else if (e instanceof InternalException) {
            InternalException internalException = (InternalException) e;
            resp.addMessage(isDebug ? e.getMessage() : "系统错误,请联系管理员");
            resp.setCode(internalException.getCode());
            // @TODO log 应进行日志报警等操作,方便追踪
        }
        // PathVariable 参数绑定失败
        else if (e instanceof MethodArgumentTypeMismatchException) {
            resp.setCode(4000);
            resp.addMessage(e.getMessage());
            status = HttpStatus.BAD_REQUEST;
        }
        //request param 请求参数缺失
        else if (e instanceof MissingServletRequestParameterException) {
            resp.setCode(4000);
            resp.addMessage(e.getMessage());
            status = HttpStatus.BAD_REQUEST;
        }
        //request 参数绑定失败
        else if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            List<FieldError> fieldErrors=bindException.getBindingResult().getFieldErrors();
            for (FieldError error : fieldErrors){
                resp.addMessage(error.getField()+":"+error.getDefaultMessage());
            }
            resp.setCode(4000);
            status = HttpStatus.BAD_REQUEST;
        }
        else if (e instanceof UsernameNotFoundException) {
            resp.setCode(4000);
            resp.addMessage(e.getMessage());
        }
        // 其他未知错误
        else {
            // @TODO log 对于未知的异常应进行日志报警等操作,方便追踪
            String message = isDebug ? e.getMessage() : "系统错误,请联系管理员";
            resp = new Resp<String>(5000, message, null);
        }
        return  new ResponseEntity<>(resp, status);
    }
}
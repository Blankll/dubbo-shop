package com.seven.dubbo.shop.exceptions.enums;

import org.springframework.http.HttpStatus;

/**
 * @author: Blank
 * @description: com.shu.backend.enums
 * @date: 1/19/20
 * @version: 1.0
 */
public enum ExceptionEnum {
    LOGINDATAERROR(HttpStatus.INTERNAL_SERVER_ERROR, 5005, "登录设计异常"),
    FILE_UPLOAD_FAILURE(HttpStatus.INTERNAL_SERVER_ERROR, 5006, "文件保存失败"),

    USER_NOT_EXISTS(HttpStatus.BAD_REQUEST, 4001, "用户名不存在或密码错误"),
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, 4002, "用户已存在"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, 4010, "用户未登录或登录超时"),
    FILE_NOT_NULL(HttpStatus.BAD_REQUEST, 4000, "文件不能为空"),
    RECORD_NOT_EXISTS(HttpStatus.BAD_REQUEST, 4003, "搜索记录不存在"),
    PERMISSION_DED(HttpStatus.FORBIDDEN, 4030, "当前用户权限不足"),
    TIME_FORMAT_ERROR(HttpStatus.BAD_REQUEST, 4000, "时间日期格式错误");

    /** http状态码 **/
    private HttpStatus status;
    /** 自定义错误码 **/
    private Integer code;
    /** 自定义错误信息 **/
    private String message;

    ExceptionEnum(HttpStatus status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

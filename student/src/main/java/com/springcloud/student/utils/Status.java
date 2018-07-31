package com.springcloud.student.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangzurong
 */
public class Status {
    /**
     * 请求参数不符合要求
     */
    public static final int BAD_REQUEST = 400;
    /**
     * 服务器内部错误
     */
    public static final int INTERNAL_ERROR = 500;
    /**
     * 请求成功
     */
    public static final int SUCCESS_STATE = 200;

    private Integer code;

    private String message;

    private Map<String,Object> extra;

    public Status() {
        this.extra = new HashMap<>();
    }

    public Status(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.extra = new HashMap<>();
    }

    public static Status wrong(String message, Object... args){
        String formattedMessage = String.format(message, args);
        return new Status(BAD_REQUEST, formattedMessage);
    }

    public static Status error(String message, Object... args){
        String formattedMessage = String.format(message, args);
        return new Status(INTERNAL_ERROR, formattedMessage);
    }

    public static Status success(String message, Object... args){
        String formattedMessage = String.format(message, args);
        return new Status(SUCCESS_STATE, formattedMessage);
    }


    public Integer getCode() {
        return code;
    }

    public Status setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Status setMessage(String message) {
        this.message = message;
        return this;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public Object get(String key) {
        return extra.get(key);
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public Status put(String key, Object value) {
        extra.put(key, value);
        return this;
    }
}

package com.ych.admin.enums;

import com.ych.common.enums.ResponseEnum;

/**
 * Created by chenhao.ye on 2017/9/17.
 */
public enum UserResponseEnum implements ResponseEnum {

    USER_EXISTS("11","用户已存在"),
    USER_CREATE_FAIL("12","用户创建失败");


    private String code;
    private String message;

    UserResponseEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

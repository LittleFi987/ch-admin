package com.ych.common.enums;

/**
 * Created by chenhao.ye on 2017/9/17.
 */
public enum StateEnum {
    INVALID(0, "有效状态"),
    NO_INVALID(1, "无效状态");


    StateEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

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
